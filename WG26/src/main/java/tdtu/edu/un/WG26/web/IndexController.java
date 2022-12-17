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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.Cart;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Repository.CartRepository;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.CartService;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;
import tdtu.edu.un.WG26.web.dto.CartDTO;
import tdtu.edu.un.WG26.web.dto.UserChangePassDTO;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/home")
public class IndexController {

	@Autowired
	private AppServices appServices;

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private CartService cartService;

	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@ModelAttribute("user")
	public UserChangePassDTO userChangePassDTO() {
		return new UserChangePassDTO();
	}

	@RequestMapping("")
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail, Model model,
			@RequestParam("pid") int pid) {
		if (userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("userName", username);
		} else if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/home?pid=0";
		}
		List<App> appList = appServices.fetchAppList();
		model.addAttribute("appList", appList);
		model.addAttribute("pid", pid);
		return "home";
	}

	@GetMapping("/detail")
	public String getAppInformation(@AuthenticationPrincipal LoadUserDetail userDetail,@RequestParam("pid") int pid, @RequestParam("id") String id, Model model) {
		if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/home/detail?pid=0&id="+id;
		}
		App appInfo = appServices.findAppByName(id);

		model.addAttribute("appInfo", appInfo);
		model.addAttribute("pid", pid);

		return "appinformation";
	}

	@RequestMapping("/games")
	public String getGamePage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model,
			@RequestParam("pid") int pid) {
		String tagName = "game";
		if (userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("userName", username);
		} else if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/games?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid", pid);
		model.addAttribute("appList", appList);
		return "appentertainment";
	}

	@RequestMapping("/books")
	public String getBookPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model,
			@RequestParam("pid") int pid) {
		String tagName = "sach";
		if (userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("userName", username);
		} else if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/books?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid", pid);
		model.addAttribute("appList", appList);
		return "appbook";
	}

	@RequestMapping("/movies")
	public String getFilmPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model,
			@RequestParam("pid") int pid) {
		String tagName = "phim";
		if (userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("userName", username);
		} else if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/movies?pid=0";
		}
		List<App> appList = appServices.fetchAppEntertainmentList(tagName);
		model.addAttribute("pid", pid);
		model.addAttribute("appList", appList);
		return "appfilm";
	}

	@RequestMapping("/cart")
	public String getCartPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model, @RequestParam("pid") int pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		}
		List<Cart> items = cartService.findAppByEmail(userDetail.getEmail());
		model.addAttribute("pid", pid);
		model.addAttribute("items", items);
		return "cart";
	}

	@RequestMapping("/user")
	public String getUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail, Model model, @RequestParam("pid") int pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		} else {
			String email = userDetail.getEmail();

			User user = userServices.findByEmail(email);

			model.addAttribute("userInfo", user);
			model.addAttribute("pid", pid);

			return "userform";
		}
	}

	@PostMapping("/user")
	public String updateUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail,
			Model model,
			@RequestParam("gender") String gender,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("avatarPath") MultipartFile avatarPath, 
			@RequestParam("pid") int pid) throws IOException {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		} else {
			User user = userServices.findByEmail(userDetail.getEmail());

			System.out.println("User data: " + user);

			if ("" == avatarPath.getOriginalFilename()) {
				user.setPhoneNumber(phoneNumber);
				user.setGender(gender);
			} else {
				Path staticPath = Paths.get("src/main/resources/static");
				Path imagePath = Paths.get("img/user-avatar");
				if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
					Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
				}
				Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath)
						.resolve(avatarPath.getOriginalFilename());
				try (OutputStream os = Files.newOutputStream(file)) {
					os.write(avatarPath.getBytes());
				}
				user.setPhoneNumber(phoneNumber);
				user.setGender(gender);
				user.setAvatarPath("/img/user-avatar/" + avatarPath.getOriginalFilename());
			}
			System.out.println("User data updated: " + user);
			model.addAttribute("pid", pid);
			userServices.update(user);
			return "redirect:/home/user?pid=" + pid;
		}
	}

	@RequestMapping("/change-pass")
	public String getChangePassPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		} else {
			return "changepass";
		}
	}

	@PostMapping("/change-pass")
	public String updateUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail,
			@Validated @ModelAttribute("user") UserChangePassDTO userChangePassDTO, BindingResult result) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		} else {
			userChangePassDTO.setEmail(userDetail.getEmail());
			userServices.changePassword(userChangePassDTO);
			return "redirect:/home/changepass?success";
		}
	}

	@GetMapping("/about")
	public String getAboutPage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model,
			@RequestParam("pid") int pid) { 
		if (userDetail != null) {
			String username = userDetail.getUsername();
			model.addAttribute("userName", username);
		} else if (userDetail == null && (pid == 1 || pid == 2)) {
			return "redirect:/about?pid=0";
		}
		model.addAttribute("pid", pid);
		return "about"; 
	}
	
	@PostMapping("/add-to-cart")
    public String addProductToCart(@Validated @ModelAttribute("cart") CartDTO cartDTO,BindingResult result,@AuthenticationPrincipal LoadUserDetail userDetail, @RequestParam("pid") int pid, @RequestParam("id") String appName, Model model) {
		App app = appServices.findAppByName(appName);
		List<Cart> items = cartService.findAppByEmailAndAppNAme(userDetail.getEmail(), appName);
		
		System.out.println(items);
		CartDTO cart = new CartDTO(userDetail.getEmail(), app.getAppName(), app.getGenre(), app.getTagName(), app.getDownloadPath());
        if(items.isEmpty() == false){
        	
            return "redirect:/home/detail?pid=" + pid + "&id="+appName+"&error";
        }
        else {        	
        	model.addAttribute("pid", pid);
        	cartService.save(cart);
        	return "redirect:/home/detail?pid=" + pid + "&id="+appName+"&success";
        }
    }
}
