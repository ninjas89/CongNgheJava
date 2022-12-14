package tdtu.edu.un.WG26.web;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;
import tdtu.edu.un.WG26.web.dto.UserChangePassDTO;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;


@Controller
@RequestMapping("/home")
public class IndexController {

	@Autowired
	private AppServices appServices;

	@Autowired
	private UserServices userServices;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
	
	@ModelAttribute("user")
	public UserChangePassDTO userChangePassDTO() {
		return new UserChangePassDTO();
	}
	
	@RequestMapping("")
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
			if(userDetail != null) {
				String username = userDetail.getUsername();
				model.addAttribute("username",username);
			}
			else if(userDetail == null && pid == 1) {
				return "redirect:/home?pid=0";
			}
			List<App> appList = appServices.fetchAppList();
			model.addAttribute("appList",appList);
			model.addAttribute("pid",pid);
			return "home";
	}
	
	@GetMapping("/detail")
	public String getAppInformation(@RequestParam("pid") int pid,@RequestParam("id") String id, Model model) {
		
		App appInfo = appServices.findAppByName(id);
		
		model.addAttribute("appInfo", appInfo);

		return "appinformation";
	}
	

  @RequestMapping("/games")
  public String getGamePage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "game";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/games?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appentertainment" ; 
  }
  
  @RequestMapping("/books")
  public String getBookPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "sach";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/books?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appbook"; 
  }
  
  @RequestMapping("/movies")
  public String getFlimPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "phim";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/movies?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "appfilm"; 
  }
  
  @RequestMapping("/cart")
  public String getCartPage(@AuthenticationPrincipal LoadUserDetail userDetail,Model model,@RequestParam("pid") int pid) {
	  String tagName = "phim";
		if(userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("username",username);
		}
		else if(userDetail == null && pid == 1) {
			return "redirect:/movies?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid",pid);  
		model.addAttribute("appList", appList);
		return "cart"; 
  }
  
  @RequestMapping("/user") 
  public String getUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail, Model model){
		if(userDetail == null) {
			return "redirect:/home?pid=0";
		}
		else {			
			String email = userDetail.getUsername();
			
			User user = userServices.findByEmail(email);
			
			model.addAttribute("userInfo", user);
			
			return "userform"; 
		}
  }
  @PostMapping("/user")
	public String updateUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail,
								@RequestParam("gender") String gender,
								@RequestParam("phoneNumber") String phoneNumber,
								@RequestParam("avatarPath") MultipartFile avatarPath) throws IOException {
		if(userDetail == null) {
			return "redirect:/home?pid=0";
		}
		else {		
			User user_data = userServices.findByEmail(userDetail.getUsername()); //tim user trong database qua email
			
			System.out.println("User data: " + user_data);
			
			if ("" == avatarPath.getOriginalFilename()) {//neu nguoi dung khong thay doi avatar mac dinh
				user_data.setPhoneNumber(phoneNumber);
				user_data.setGender(gender);
			}
			else {// nguoi dung thay doi avatar
				Path staticPath = Paths.get("src/main/resources/static");
				Path imagePath = Paths.get("img/user-avatar");
				if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
					Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
				}
				Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(avatarPath.getOriginalFilename());
				try (OutputStream os = Files.newOutputStream(file)) {
					os.write(avatarPath.getBytes());
				}
				user_data.setPhoneNumber(phoneNumber);
				user_data.setGender(gender);
				user_data.setAvatarPath("/img/user-avatar/" + avatarPath.getOriginalFilename());
			}
		System.out.println("User data updated: " + user_data);
		userServices.update(user_data);
		return "redirect:/home/user";
		}
	}
  @RequestMapping("/changepass") 
  public String getChangePassPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model){
		if(userDetail == null) {
			return "redirect:/home?pid=0";
		}
		else {
			return "changepass"; 
		}
  }
  @PostMapping("/changepass")
	public String updateUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail,@Validated @ModelAttribute("user")  UserChangePassDTO userChangePassDTO, BindingResult result) {
		if(userDetail == null) {
			return "redirect:/home?pid=0";
		}
		else {
			System.out.println(userDetail.getUsername());
			userChangePassDTO.setEmail(userDetail.getUsername());
			System.out.println(userChangePassDTO);
			userServices.changePassword(userChangePassDTO);
			return "redirect:/home/changepass?success";
		}
	}
}
  
