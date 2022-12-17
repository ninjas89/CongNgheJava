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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.Card;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.AdminServices;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.CardServices;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;
import tdtu.edu.un.WG26.web.dto.AppDto;

@Controller
public class AdminController {
	@Autowired
	private AppServices appServices;

	@Autowired
	private AdminServices adminServices;

	@Autowired
	private CardServices cardServices;
	
	@Autowired
	private UserServices userServices;

	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@ModelAttribute("app") 
	public AppDto addAppDto() {
		return new AppDto();
	}

	@GetMapping("/admin")
	public String adminDashboard() {
		return "admin"; 
	}

	@GetMapping("admin/get-all-user")
	public String getAllUser(@AuthenticationPrincipal LoadUserDetail userDetail, Model model, @RequestParam("pid") Integer pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		}
		List<User> userList = adminServices.fetchAllUser();
		model.addAttribute("userName",userDetail.getUsername());
		model.addAttribute("userList", userList);
		model.addAttribute("pid", pid);
		return "admin";
	}

	@PostMapping("admin/delete-user")
	public String deleteUser(@AuthenticationPrincipal LoadUserDetail userDetail,@RequestParam("id") Long id, Model model, @RequestParam("pid") Integer pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		}
		userServices.deleteUserById(id);
		model.addAttribute("pid", pid);
		return "redirect:/admin/get-all-user?pid="+pid;
	}
	
	@GetMapping("admin/get-all-app")
	public String getAllApp(@AuthenticationPrincipal LoadUserDetail userDetail,Model model, @RequestParam("pid") Integer pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		}
		List<App> appList = appServices.fetchAppList();
		model.addAttribute("userName",userDetail.getUsername());
		model.addAttribute("appList", appList);
		model.addAttribute("pid", pid);
		return "admin";
	}

	@GetMapping("admin/add-app")
	public String getAddAppPage() {
		return "addapp";  
	}

	@PostMapping("admin/add-app")
	public String postApp(@AuthenticationPrincipal LoadUserDetail userDetail, 
						@RequestParam("genre") String genre,
						@RequestParam("tagName") String tagName,
						@RequestParam("appName") String appName,
						@RequestParam("description") String description,
						@RequestParam("downloadPath") MultipartFile downloadPath,
						@RequestParam("avatarPath") MultipartFile avatarPath) throws IOException {
		
		Path staticPath = Paths.get("src/main/resources/static");
        Path imagePath = Paths.get("img/upload");
        
        Path filePath = Paths.get("file");
        
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        if(!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(filePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(filePath));
        }
        
        Path image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(avatarPath.getOriginalFilename());
        
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(filePath).resolve(downloadPath.getOriginalFilename());
        
        try (OutputStream osm = Files.newOutputStream(image)) {
            osm.write(avatarPath.getBytes());
        }
        try (OutputStream osf = Files.newOutputStream(file)) {
            osf.write(downloadPath.getBytes());
        }
    
        AppDto appDto = new AppDto(genre, tagName, appName, description, "/file/" + downloadPath.getOriginalFilename(), "/img/upload/" + avatarPath.getOriginalFilename());
		 
		appServices.save(appDto);
		
		return "redirect:/admin/add-app?success";
	}

	@PostMapping("admin/delete-app")
	public String deleteApp(@AuthenticationPrincipal LoadUserDetail userDetail, @RequestParam("id") Long id, Model model, @RequestParam("pid") Integer pid) {
		appServices.deleteAppById(id);
		model.addAttribute("pid", pid);
		return "redirect:/admin/get-all-app?pid=" + pid;
	}
	
	@GetMapping("admin/get-all-card")
	public String getAllCard(@AuthenticationPrincipal LoadUserDetail userDetail, Model model, @RequestParam("pid") Integer pid) {
		if (userDetail == null) {
			return "redirect:/home?pid=0";
		}
		List<Card> cardList = cardServices.fetchAllCard();
		model.addAttribute("userName",userDetail.getUsername());
		model.addAttribute("cardList", cardList);
		model.addAttribute("pid", pid);
		return "admin";
	}
}
