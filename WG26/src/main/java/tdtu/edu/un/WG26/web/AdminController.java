package tdtu.edu.un.WG26.web;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.un.WG26.Service.AppServices;
import tdtu.edu.un.WG26.web.dto.AppDto;

@Controller
public class AdminController {
	@Autowired
	private AppServices appServices;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@ModelAttribute("app") 
	public AppDto addAppDto() {
		return new AppDto();
	}

	public AdminController(AppServices appServices) {
		super();
		this.appServices = appServices;
	}

	@GetMapping("/addapp")
	public String getAddAppPage() {
		return "addapp";  
	}

	@PostMapping("/addapp")
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
        
		/*
		 * byte[] bytes = null; try { bytes = imageFile.getBytes(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * String folderPath = "/img/upload/" + imageFile.getOriginalFilename(); Path
		 * path = Paths.get(folderPath); try {
		 * 
		 * Files.write(path, bytes); System.out.println("-----"); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } AppDto appDto */
        AppDto appDto = new AppDto(genre, tagName, appName, description, price, publisher, 0, "", "/img/upload/" + avatarPath.getOriginalFilename());
		 
		appServices.save(appDto);
		
		return "redirect:/addapp";
	}
}
