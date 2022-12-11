package tdtu.edu.un.WG26.config;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;


@Component
public class UserLoged implements HttpSessionBindingListener, Serializable{

}
