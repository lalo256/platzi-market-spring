package com.alucardlalo.platzimarket.web.controller;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indica que esta clase es un controlador de API Rest
@RequestMapping ("/products")//indica que que sitio aceptara las peticiones
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")//se usa para lanzar la api desde la API y con que direcionamiento se accede
    //se entra desde http://localhost:8090/platzi-market/api/products/all
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")//la notacion es para especificar el numero de id y path variable lo especifica
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        //se entra desde http://localhost:8090/platzi-market/api/products/(numero de id)
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    //al igual que el anterior se utiliza con una diferencia y es la especificacion de category para que Spring no confunda el de arriba con el de category
    //se entra desde http://localhost:8090/platzi-market/api/category/(numero de id)
    public Optional <List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")//salva los datos dentro de la API
    //se entra desde http://localhost:8090/platzi-market/api/save (con una seleccion post en postman)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    //se entra desde http://localhost:8090/platzi-market/api/delete/(numero id del objeto a eliminar) con una seleccion Delete en postman
    public Boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

    /*la seccion de save y delete se pueden verificar en postman poniendo el direccionamiento y
    * selecionando lo que se va crear en save como RAW y JSON asi como especificar sus atributos
    * (nombre,precio,stock,category)y en delete solo poniendo el id del producto*/

}
