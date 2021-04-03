package com.nildoweb.todolist.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.domain.User;
import com.nildoweb.todolist.repository.TodoRepository;
import com.nildoweb.todolist.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private TodoRepository todoReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		todoReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.save(Arrays.asList(maria, alex, bob));

		Todo todo1 = new Todo(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SÃ£o Paulo. AbraÃ§os!", new AuthorDTO(maria));
		Todo todo2 = new Todo(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um Ã³timo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		todo1.getComments().addAll(Arrays.asList(c1, c2));
		todo2.getComments().addAll(Arrays.asList(c3));
		
		todoReposiroty.save(Arrays.asList(todo1, todo2));
		
		maria.gettodos().addAll(Arrays.asList(todo1, todo2));
		userReposiroty.save(maria);
	}

}
