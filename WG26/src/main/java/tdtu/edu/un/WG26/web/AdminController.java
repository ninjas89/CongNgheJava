package tdtu.edu.un.WG26.web;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String getAllUser(Model model) {
		List<User> userList = adminServices.fetchAllUser();
		model.addAttribute("userList", userList);
		return "admin";
	}

	@PostMapping("admin/delete-user")
	public String deleteUser(@RequestParam("id") Long id) {
		userServices.deleteUserById(id);
		return "redirect:/admin/get-all-user";
	}
	
	@GetMapping("admin/get-all-app")
	public String getAllApp(Model model) {
		List<App> appList = appServices.fetchAppList();
		model.addAttribute("appList", appList);
		return "admin";
	}

	@GetMapping("admin/add-app")
	public String getAddAppPage() {
		return "addapp";  
	}

	@PostMapping("admin/add-app")
	public String postApp(@RequestParam("genre") String genre,
						@RequestParam("tagName") String tagName,
						@RequestParam("appName") String appName,
						@RequestParam("description") String description,
						@RequestParam("price") Integer price,
						@RequestParam("publisher") String publisher,
						@RequestParam("downloadPath") MultipartFile downloadPath,
						@RequestParam("avatarPath") MultipartFile avatarPath) throws IOException {
		
		Path staticPath = Paths.get("src/main/resources/static");
        Path imagePath = Paths.get("img/upload");
        
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(avatarPath.getOriginalFilename());
        
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(avatarPath.getBytes());
        }
    
        AppDto appDto = new AppDto(genre, tagName, appName, description, price, publisher, 0, "", "/img/upload/" + avatarPath.getOriginalFilename());
		 
		appServices.save(appDto);
		
		return "redirect:/admin/add-app";
	}

	@GetMapping("admin/edit-app")
	public String editAppById(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		App app = appServices.findAppById(id);
		model.addAttribute("app", app);
		return "addapp";
	}

	@PostMapping("admin/delete-app")
	public String deleteApp(@RequestParam("id") Long id) {
		appServices.deleteAppById(id);
		return "redirect:/admin/get-all-app";
	}
	
	@GetMapping("admin/get-all-card")
	public String getAllCard(Model model) {
		List<Card> appList = cardServices.fetchAllCard();
		model.addAttribute("appList", appList);
		return "admin";
	}
}
