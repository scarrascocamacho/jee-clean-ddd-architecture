/**
 *
 */
package jeecleandddarchitecture.helloworld.boundary;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.helloworld.entity.HelloWorldBean;

/**
 * @author scarrasco
 *
 */
// Controller
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World From a Java Bean");
	}

	/// hello-world/path-variable/helloworld
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable final String name) {
		// throw new RuntimeException("Something went wrong");
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
