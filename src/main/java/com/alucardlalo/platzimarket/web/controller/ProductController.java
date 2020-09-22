package com.alucardlalo.platzimarket.web.controller;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAll(){
    //se cambio para controlar las peticiones HTTP
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")//la notacion es para especificar el numero de id y path variable lo especifica
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        //se entra desde http://localhost:8090/platzi-market/api/products/(numero de id)
        return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //el metodo orElse se utiliza para el caso en que no exista el id solicitado y responda not found
    }

    @GetMapping("/category/{categoryId}")
    //al igual que el anterior se utiliza con una diferencia y es la especificacion de category para que Spring no confunda el de arriba con el de category
    //se entra desde http://localhost:8090/platzi-market/api/category/(numero de id)
    public ResponseEntity <List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))//mapea los resultados
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));//contesta si este no existe
    }

    @PostMapping("/save")//salva los datos dentro de la API
    //se entra desde http://localhost:8090/platzi-market/api/save (con una seleccion post en postman)
    public ResponseEntity <Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);//respuesta http de objeto creado
    }

    @DeleteMapping("/delete/{id}")
    //se entra desde http://localhost:8090/platzi-market/api/delete/(numero id del objeto a eliminar) con una seleccion Delete en postman
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);//respuesta si borra
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);//respuesta si no existe
        }
    }

    /*la seccion de save y delete se pueden verificar en postman poniendo el direccionamiento y
    * selecionando lo que se va crear en save como RAW y JSON asi como especificar sus atributos
    * (nombre,precio,stock,category)y en delete solo poniendo el id del producto*/

}
