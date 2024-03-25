package com.app;

import com.app.persistence.entities.PermissionEntity;
import com.app.persistence.entities.RoleEntity;
import com.app.persistence.entities.RoleEnum;
import com.app.persistence.entities.UserEntity;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner init(){
		return args -> {
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();


			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionEntities(Set.of(createPermission,updatePermission,deletePermission,readPermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionEntities(Set.of(createPermission,readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionEntities(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionEntities(Set.of(createPermission,updatePermission,deletePermission,readPermission,refactorPermission))
					.build();



			UserEntity userKevin= UserEntity.builder()
					.userName("kevin")
					.password("12345")
					.roles(Set.of(roleDeveloper))
					.accountNoExpired(true)
					.credentialsNoExpired(true)
					.accountNoLocked(true)
					.isEnabled(true)
					.build();

			UserEntity userJuan= UserEntity.builder()
					.userName("juan")
					.password("12345")
					.roles(Set.of(roleAdmin))
					.accountNoExpired(true)
					.credentialsNoExpired(true)
					.accountNoLocked(true)
					.isEnabled(true)
					.build();

			UserEntity userSofia= UserEntity.builder()
					.userName("sofia")
					.password("12345")
					.roles(Set.of(roleUser))
					.accountNoExpired(true)
					.credentialsNoExpired(true)
					.accountNoLocked(true)
					.isEnabled(true)
					.build();

			UserEntity userPedri= UserEntity.builder()
					.userName("pedri")
					.password("12345")
					.roles(Set.of(roleInvited))
					.accountNoExpired(true)
					.credentialsNoExpired(true)
					.accountNoLocked(true)
					.isEnabled(true)
					.build();
			this.repository.saveAll(List.of(userKevin,userSofia,userJuan,userPedri));
		};
	}

 */

}
