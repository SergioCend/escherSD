/* ========================================================================
 * Copyright 2014 Escher96
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Escher96

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201410152247

*/

package co.edu.uniandes.csw.Escher96.autor.logic.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.Escher96.autor.logic.dto.AutorPageDTO;
import co.edu.uniandes.csw.Escher96.autor.logic.dto.AutorDTO;
import co.edu.uniandes.csw.Escher96.autor.logic.api.IAutorLogicService;
import co.edu.uniandes.csw.Escher96.autor.persistence.AutorPersistence;
import co.edu.uniandes.csw.Escher96.autor.persistence.api.IAutorPersistence;
import co.edu.uniandes.csw.Escher96.autor.persistence.entity.AutorEntity;
import co.edu.uniandes.csw.Escher96.autor.persistence.converter.AutorConverter;
import static co.edu.uniandes.csw.Escher96.util._TestUtil.*;

@RunWith(Arquillian.class)
public class AutorLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(AutorLogicService.class.getPackage())
				.addPackage(IAutorLogicService.class.getPackage())
				.addPackage(AutorPersistence.class.getPackage())
				.addPackage(AutorEntity.class.getPackage())
				.addPackage(IAutorPersistence.class.getPackage())
                .addPackage(AutorDTO.class.getPackage())
                .addPackage(AutorConverter.class.getPackage())
                .addPackage(AutorEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IAutorLogicService autorLogicService;
	
	@Inject
	private IAutorPersistence autorPersistence;	

	@Before
	public void configTest() {
		try {
			clearData();
			insertData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearData() {
		List<AutorDTO> dtos=autorPersistence.getAutors();
		for(AutorDTO dto:dtos){
			autorPersistence.deleteAutor(dto.getId());
		}
	}

	private List<AutorDTO> data=new ArrayList<AutorDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			AutorDTO pdto=new AutorDTO();
			pdto.setName(generateRandom(String.class));
			pdto=autorPersistence.createAutor(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createAutorTest(){
		AutorDTO ldto=new AutorDTO();
		ldto.setName(generateRandom(String.class));
		
		
		AutorDTO result=autorLogicService.createAutor(ldto);
		
		Assert.assertNotNull(result);
		
		AutorDTO pdto=autorPersistence.getAutor(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getAutorsTest(){
		List<AutorDTO> list=autorLogicService.getAutors();
		Assert.assertEquals(list.size(), data.size());
        for(AutorDTO ldto:list){
        	boolean found=false;
            for(AutorDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getAutorTest(){
		AutorDTO pdto=data.get(0);
		AutorDTO ldto=autorLogicService.getAutor(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteAutorTest(){
		AutorDTO pdto=data.get(0);
		autorLogicService.deleteAutor(pdto.getId());
        AutorDTO deleted=autorPersistence.getAutor(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateAutorTest(){
		AutorDTO pdto=data.get(0);
		
		AutorDTO ldto=new AutorDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		
		
		autorLogicService.updateAutor(ldto);
		
		
		AutorDTO resp=autorPersistence.getAutor(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
	}
	
	@Test
	public void getAutorPaginationTest(){
		
		AutorPageDTO dto1=autorLogicService.getAutors(1,2);
		Assert.assertNotNull(dto1);
        Assert.assertEquals(dto1.getRecords().size(),2);
        Assert.assertEquals(dto1.getTotalRecords().longValue(),3L);
		
		
		AutorPageDTO dto2=autorLogicService.getAutors(2,2);
		Assert.assertNotNull(dto2);
        Assert.assertEquals(dto2.getRecords().size(),1);
        Assert.assertEquals(dto2.getTotalRecords().longValue(),3L);
		
		for(AutorDTO dto:dto1.getRecords()){
        	boolean found=false;
            for(AutorDTO pdto:data){
            	if(dto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
        
        for(AutorDTO dto:dto2.getRecords()){
        	boolean found=false;
            for(AutorDTO pdto:data){
            	if(dto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
        
        AutorPageDTO dto3=autorLogicService.getAutors(1,3);
		Assert.assertNotNull(dto3);
        Assert.assertEquals(dto3.getRecords().size(),data.size());
        Assert.assertEquals(dto3.getTotalRecords().longValue(),data.size());
		
		for(AutorDTO dto:dto3.getRecords()){
        	boolean found=false;
            for(AutorDTO pdto:data){
            	if(dto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	
}