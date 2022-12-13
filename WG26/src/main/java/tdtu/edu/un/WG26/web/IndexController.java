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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.un.WG26.Model.App;
import tdtu.edu.un.WG26.Model.User;
import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.Service.UserServices;
import tdtu.edu.un.WG26.config.LoadUserDetail;
import tdtu.edu.un.WG26.web.dto.UserRegistrationDto;

@Controller
public class IndexController {

	@Autowired
	private AppServices appServices;

	@Autowired
	private UserServices userServices;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@GetMapping("/home")
	public String getUserHome(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		List<App> listApp = appServices.fetchAppList();
		if (userDetail == null) {
			return "redirect: /home?";
		} else {
			String username = userDetail.getUsername();
			model.addAttribute("listApp", listApp);
			model.addAttribute("username", username);
			return "home";
		}
	}

	@GetMapping("/home/{appName}")
	public String getAppInformation(@PathVariable("appName") String appName, Model model) {
		App appInfo = appServices.findAppByName(appName);

		model.addAttribute("appInfo", appInfo);

		return "appinformation";
	}

	@GetMapping("/home/app-entertainment")
	public String getAppEntertainmentHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "game";
		String username = userDetail.getUsername();

		List<App> appList = appServices.fetchAppEntertainmentList(tagName);

		model.addAttribute("appList", appList);
		model.addAttribute("username", username);

		return "appentertainment";
	}

	@GetMapping("/home/app-book")
	public String getAppBookHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "sach";
		String username = userDetail.getUsername();

		List<App> appList = appServices.fetchAppEntertainmentList(tagName);

		model.addAttribute("appList", appList);
		model.addAttribute("username", username);

		return "appbook";
	}

	@GetMapping("/home/app-film")
	public String getAppFilmHomepage(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String tagName = "phim";
		String username = userDetail.getUsername();

		List<App> appList = appServices.fetchAppEntertainmentList(tagName);

		model.addAttribute("appList", appList);
		model.addAttribute("username", username);

		return "appfilm";
	}

	@GetMapping("/home/account")
	public String getUserInfo(@AuthenticationPrincipal LoadUserDetail userDetail, Model model) {
		String email = userDetail.getUsername();

		User user = userServices.findByEmail(email);

		model.addAttribute("userInfo", user);

		return "userform";
	}

	@PostMapping("/home/account/{id}")
	public String updateUserInfo(@RequestParam("firstName") String firstName,
								@RequestParam("lastName") String lastName,
								@RequestParam("email") String email,
								@RequestParam("gender") String gender,			
								@RequestParam("avatarPath") MultipartFile avatarPath) throws IOException {
		
		User user_data = userServices.findByEmail(email); //tim user trong database qua email
		
		System.out.println("User data: " + user_data);
		
		if ("" == avatarPath.getOriginalFilename()) {//neu nguoi dung khong thay doi avatar mac dinh
			user_data.setFirstName(firstName);
			user_data.setLastName(lastName);
			user_data.setEmail(email);
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

			user_data.setFirstName(firstName);
			user_data.setLastName(lastName);
			user_data.setEmail(email);
			user_data.setGender(gender);
			user_data.setAvatarPath("/img/user-avatar/" + avatarPath.getOriginalFilename());
		}
		
		System.out.println("User data updated: " + user_data);
		/* userServices.update(user); */
	
		return "redirect:/home/account";
	}
}
