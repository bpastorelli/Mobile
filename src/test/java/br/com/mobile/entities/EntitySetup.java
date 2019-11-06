package br.com.mobile.entities;

import br.com.mobile.interfaces.BasePage;
import br.com.mobile.interfaces.SetupEnviroment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitySetup {
	
	private BasePage basePage;
	
	private SetupEnviroment setup;

}
