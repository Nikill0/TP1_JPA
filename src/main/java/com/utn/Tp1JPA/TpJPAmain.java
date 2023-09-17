package com.utn.Tp1JPA;


import com.utn.Tp1JPA.Entidades.*;
import com.utn.Tp1JPA.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpJPAmain {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(TpJPAmain.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {

			Producto producto1 = Producto.builder().tipo("manufacturado")
					.tiempoEstimadoDeCocina(20)
					.denominacion("Hamgurguesa")
					.precioVenta(140)
					.precioCompra(80)
					.stockActual(80)
					.stockMinimo(15)
					.unidadMedida("gramos")
					.receta("carne, lechuga, tomate, cebolla, queso, pan de papa")
					.build();

			Producto producto2 = Producto.builder().tipo("manufacturado")
					.tiempoEstimadoDeCocina(10)
					.denominacion("Pizza")
					.precioVenta(200)
					.precioCompra(50)
					.stockActual(30)
					.stockMinimo(20)
					.unidadMedida("gramos")
					.receta("masa, salsa, queso, tomate, jamon cocido,morrón")
					.build();



			List<Producto> productos=new ArrayList<>();
			productos.add(producto1);
			productos.add(producto2);

			Rubro rubro = Rubro.builder().denominacion("Comida rápida")
					.productos(productos)
					.build();

			rubroRepositorio.save(rubro);

			Domicilio domicilio1= Domicilio.builder().calle("Calle número 1")
					.numero("16")
					.localidad("Las Heras")
					.build();

			Domicilio domicilio2= Domicilio.builder().calle("Calle número 2")
					.numero("27")
					.localidad("Las Heras")
					.build();



			List<Domicilio> domicilios = new ArrayList<>();
			domicilios.add(domicilio1);
			domicilios.add(domicilio2);


			DetallePedido detallePedido1 = DetallePedido.builder().cantidad(1)
					.producto(producto1)
					.subtotal(producto1.getPrecioVenta())
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder().cantidad(1)
					.producto(producto2)
					.subtotal(producto2.getPrecioVenta())
					.build();



			List<DetallePedido> detallesPedido = new ArrayList<>();
			detallesPedido.add(detallePedido1);
			detallesPedido.add(detallePedido2);

			Factura factura= Factura.builder().numero(777)
					.fecha(new Date())
					.descuento(0)
					.formaPago("Efectivo")
					.total(350)
					.build();




			Pedido pedido1= Pedido.builder().estado("En preparación")
					.fecha(new Date())
					.tipoEnvio("Delivery")
					.detalles(detallesPedido)
					.factura(factura)
					.build();



			List<Pedido> pedidos = new ArrayList<>();
			pedidos.add(pedido1);

			Cliente cliente1= Cliente.builder().nombre("Camila")
					.apellido("Mañani")
					.telefono("desconocido")
					.email("mañanicami2023@gmail.com")
					.domicilios(domicilios)
					.pedidos(pedidos)
					.build();
			clienteRepositorio.save(cliente1);

			List<Cliente> clientes= clienteRepositorio.findAll();

			for (Cliente cliente: clientes){
				System.out.println(cliente.getNombre());
			}
		};
	}
}