package com.santunu23.bookstorewebservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("myBooks")
public class BookResource {
	
BookRepository br=new BookRepository();
@GET
@Produces(MediaType.APPLICATION_XML)
public List<MyBookStore> getBookDetails(){
	return br.getBooks();
}

@GET
@Path("myBooks/{id}")
@Produces(MediaType.APPLICATION_XML)
public MyBookStore getMyBookStore(@PathParam("id") int id){
return br.getBook(id);
}

@POST
@Path("myBooks")
public MyBookStore create(MyBookStore ma){
	br.createMyBook(ma);
	return ma;
}

@PUT
@Path("updateemyBooks")
@Consumes(MediaType.APPLICATION_XML)
public MyBookStore updateMybookstore(MyBookStore rs){
	br.update(rs);
	return rs;
	
}





@DELETE
@Path("deletemyBooks/{id}")
public MyBookStore deleteMybookstore(@PathParam("id") int id){
MyBookStore mb=br.getBook(id);
if(mb.getBookList()!=0)
      br.delete(id);
  return mb;
}




}
