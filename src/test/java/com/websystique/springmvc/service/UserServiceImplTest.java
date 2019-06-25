package com.websystique.springmvc.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.websystique.springmvc.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	public UserServiceImpl userServiceImpl;

	@Mock
	List<User> users;

	@Test
	public void testFindAllUsers() {
		when(userServiceImpl.findAllUsers())
		.thenReturn(Arrays.asList(new User(1, "Sam", 30, 70000),new User(2, "Tom",40, 50000),new User(3, "Jerome",45, 30000),
				new User(4, "Silvia",50, 40000)));
		assertThat(userServiceImpl.findAllUsers(),is(Arrays.asList(new User(1, "Sam", 30, 70000),new User(2, "Tom",40, 50000),new User(3, "Jerome",45, 30000),
				new User(4, "Silvia",50, 40000))));
	}

	@Test
	public void testFindById(){
		//given
		given(userServiceImpl.findById(Mockito.anyLong())).willReturn(new User(10,"Amin",120000,23));
		//assert
		assertThat(userServiceImpl.findById(anyLong()),is(new User(10,"Amin",120000,23)));
	}

	@Test
	public void testFindByName(){
		//given
		given(userServiceImpl.findByName(anyString())).willReturn(new User(46,"West",21,200000));
		//assert
		assertThat(userServiceImpl.findByName(anyString()),is(new User(46,"West",21,200000)));
	}

	//need to inject the list object using @InjectMocks
	@Test
	public void testSaveUser(){
		//given
		given(users.add(new User())).willReturn(true);

		//when
		userServiceImpl.saveUser(new User());

		//verify
		verify(users,times(1)).add(new User(1,null,0,0.0));
	}

	//need to inject the list object using @InjectMocks
	@Test
	public void testUpdateUser(){
		//given
		User ip=new User();
		given(users.set(0,ip)).willReturn(ip);

		//when
		userServiceImpl.updateUser(ip);

		users.add(0,new User(1, "S", 23, 120000));

		//verify
		verify(users).set(0,ip);
	}

	@Test
	public void testDeleteUserById(){
		//given

	}

	@Test
	public void testIsUserExist(){
		//given
		given(userServiceImpl.isUserExist(new User(1,"west",23,12))).willReturn(true);

		//verify
		assertThat(userServiceImpl.isUserExist(new User(1,"west",23,12)),is(true));
	}

	//need to inject the list object using @InjectMocks
	@Test
	public void testDeleteAllUsers(){
		//when
		userServiceImpl.deleteAllUsers();

		//verify
		verify(users).clear();
	}

}
