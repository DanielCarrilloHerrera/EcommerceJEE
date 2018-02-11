<%@page import="cad.CategoriaCad"%>
<%@page import="JavaBeans.Categoria"%>
<%@page import="java.util.ArrayList"%>
<div class="left-sidebar">
						<h2>Categorías</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                                    <%! ArrayList<Categoria> listaSuperior = CategoriaCad.listarCategoriaSuperior();
                                                    ArrayList<Categoria> listaSubCategoria = CategoriaCad.listarSubCategoria();
                                                    int codigo = 0;%>
                                                    <%  for(int i = 0; i < listaSuperior.size(); i++) { 
                                                        codigo = listaSuperior.get(i).getCodigo();
                                                    %>
                                                    <div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a <%if (CategoriaCad.esSuperior(codigo)) {%>
                                                                                    data-toggle="collapse" data-parent="#accordian" 
                                                                                    <%}%>
                                                                                    href="#<%= listaSuperior.get(i).getCodigo() %>">
                                                                                    <%if (CategoriaCad.esSuperior(codigo)){%><span class="badge pull-right"><i class="fa fa-plus"></i></span><%}%>
											<a href="?category=<%=codigo%>"><%= listaSuperior.get(i).getNombre() %></a>
										</a>
									</h4>
								</div>
								<div id="<%= listaSuperior.get(i).getCodigo() %>" class="panel-collapse collapse">
									<div class="panel-body">
										<ul><%for(int j = 0; j < listaSubCategoria.size(); j++){
                                                                                        if(listaSubCategoria.get(j).getCategoria_superior() == listaSuperior.get(i).getCodigo()){
                                                                                             %>
                                                                                    <li><a href="?category=<%=codigo%>"><%=listaSubCategoria.get(j).getNombre()%></a></li>    
                                                                                    <%listaSubCategoria.remove(j);%>
                                                                                    <%}}%>
                                                                                </ul>
									</div>
								</div>
							</div>
						<% } %>	
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Marcas</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#"> <span class="pull-right">(56)</span>Nike</a></li>
									<li><a href="#"> <span class="pull-right">(27)</span>Adidas</a></li>
									<li><a href="#"> <span class="pull-right">(32)</span>Polo</a></li>
									<li><a href="#"> <span class="pull-right">(5)</span>Puma</a></li>
									<li><a href="#"> <span class="pull-right">(9)</span>Boude</a></li>
									<li><a href="#"> <span class="pull-right">(4)</span>ACB</a></li>
								</ul>
							</div>
						</div><!--/brands_products-->

						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
