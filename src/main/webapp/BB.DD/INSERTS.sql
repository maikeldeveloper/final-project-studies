INSERT INTO `familia_producto` (`COD_FAM`, `NOM_FAM`, `POSICION`) VALUES ('2432', 'Entrantes', '1');
INSERT INTO `familia_producto` (`COD_FAM`, `NOM_FAM`, `POSICION`) VALUES ('3241', 'Platos', '2');
INSERT INTO `familia_producto` (`COD_FAM`, `NOM_FAM`, `POSICION`) VALUES ('6512', 'Menus', '3');
INSERT INTO `familia_producto` (`COD_FAM`, `NOM_FAM`, `POSICION`) VALUES ('6592', 'Postres', '4');
INSERT INTO `familia_producto` (`COD_FAM`, `NOM_FAM`, `POSICION`) VALUES ('3247', 'Bebidas', '5');

INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('222', '6592', 'Helados', 'helados_18329');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('321', '6592', 'Fruta', 'frutas-128');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('231', '6592', 'Tartas', 'tartas_18329');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('241', '3247', 'Refrescos', 'refrescos');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('242', '3247', 'Zumos', 'zumos');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('243', '3247', 'Alcoholicas', 'alcoholicas');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('400', '3241', 'India', 'india-ico');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('401', '3241', 'Japon', 'japan-ico');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('402', '3241', 'Thailandia', 'thai-ico');
INSERT INTO `subfamilia_producto` (`COD_SUB`, `COD_FAM`, `NOM_SUB`, `IMG_SUB`) VALUES ('100', '2432', 'Exoticos', 'japan-ico');

INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('30', '243', 'Mahou Clasica', '1.20', 'Refrescante cerveza','mahou_classica');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('31', '243', 'Mahou 5 Estrellas', '1.20', 'Refrescante cerveza','mahou_5_estrellas');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('32', '243', 'Botella Rivera del Duero', '5.80', 'Vino tinto','vino_tinto');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('33', '243', 'Botella Aura, Rueda', '4.80', 'Vino Blanco','vino_blanco');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('34', '243', 'Botella Sake', '6.80', 'Botella de Sake Japones','sake');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('20', '241', 'Fanta Naranja', '1.80', 'Refrescante fanta de naranja','fanta_naranja');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('21', '241', 'Fanta Limon', '1.80', 'Refrescante fanta de limon','fanta_limon');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('22', '241', 'Fanta Twist', 1.80, 'Refrescante fanta de twist','fanta_twist');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('23', '241', 'Coca-Cola', '1.80', 'Refrescante coca-cola clasica','cocacola');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('24', '241', 'Coca-Cola Zero', '1.80', 'Refrescante coca-cola zero','cocacola_zero');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('10', '242', 'Zumo Zanahoria', '2.80', 'Exquisito zumo de zanahoria','zumo_zanahoria');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('11', '242', 'Zumo Pi�a', '2.80', 'Exquisito zumo de Pi�a','zumo_pinna');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('12', '242', 'Zumo Kiwi', '2.80', 'Exquisito zumo de kiwi','zumo_kiwi');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('13', '242', 'Zumo Naranja', '2.80', 'Exquisito zumo de naranja','zumo_naranja');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('279', '222', 'Anmitsu Japones', '4.80', 'Helado combinado con frutas tipico de Japon','anmitsu');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('280', '231', 'Brownei de Chocolate', 5.50, 'Brownei de Chocolate casero','brownie');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('281', '231', 'Muffin Trichocolate', '3.80', 'Muffin de tres chocolates','muffin');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('282', '231', 'Locura de Chocolate', '5.20', 'Deliciosa tarta de chocolate','tarta_chocolate');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('283', '231', 'Trufas', '4.10', 'Riquisimas trufas de chocolate, frias','trufas');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('288', '231', 'Volcan de Chocolate', 4.10, 'Volcan de chocolate especial de la casa','volca_chocolate');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('284', '222', 'Helado de chocolate', '3.80', 'Helado de chocolate casero','helado_chocolate');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('285', '222', 'Helado de fresa', '3.80', 'Helado de fresa casero','helado_fresa');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('286', '222', 'Helado de limon', '3.80', 'Helado de limon casero','helado_limon');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('287', '222', 'Helado de pitufo', '3.80', 'Helado de pitufo casero','helado_pitufo');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('701', '321', 'Sandia', '1.15', 'Sandia de Carranque 1 Racion','987654321');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('702', '321', 'Melon', '1.15', 'Melon de Arroyo Molinos 1 Racion','357951645');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('703', '321', 'Pi�a', '1.15', 'Pi�a 1 Racion','456789123');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1205', '241', 'Fanta Naranja', 2.15, 'Refresco de Fanta Naranja, 33ml','4862557931');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1300', '400', 'Kati Roll', '9.15', 'Cuatro rooles de deliciosas fajitas idias','kati_roll');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1301', '400', 'Pollo Tikka Massala', '11.90', 'Pollo al estilo tikka massala con curry, jengibre,...','pollo_tikka_massala');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1302', '400', 'Pollo al curry', '12.90', 'Pollo al estilo tradicional con curry picante','pollo_al_curry');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1303', '400', 'Pollo Tandori', '9.15', 'Pollo tandori tipico y tradicional del sur de la india','pollo_tandori');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1304', '400', 'Uttapam', 12.15, 'Uttapam o mas conocida familiarmente como pizza india con salsa de mango y yogurt para mojar','32165852');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1404', '401', 'Uramaki Aguacate y Atun', 11.15, 'Delicioso roll califoniano de atun y aguacate','uramaki_aguacate_salmon');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1405', '401', 'Spyci california roll', '12.15', 'Delicioso roll estilo califoniano picante','spicy_uramaki_roll');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1406', '401', 'Yakisoba', '9.15', 'Noodles de arroz o huevo con la tipica salsa yakisoba de japon','yakisoba');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1425', '402', 'Pad Thai', 10.90, 'Tradicional Plato Thainlandes de noodles','pad_thail');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1426', '402', 'Curry Massaman', '11.90', 'Tradicional Plato Thainlandes de curry','curry_massaman_thai');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1427', '402', 'Poh piah', '8.90', 'Tradicional Plato Thainlandes','poh_piah');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1428', '402', 'Satay thai', 7.90, 'Brocheta de pollo y salsa de cacahuete','Satay_thai');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1101', '100', 'Sopa de Miso', '7.15', 'Tradicional sopa japonesa','sopa_miso');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1102', '100', 'Ensalada Japonesa', 6.15, 'Deliciosa ensalada con arroz con toque japones','ensalada_japones');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1104', '100', 'Som tam', 7.15, 'Deliciosa ensalada thailandesa','som_taml_ensalada');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1103', '100', 'Momo Indio', 6.15, '8 piezas de delicioso momo indio','momo');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1408', '401', 'Salmon Roll', 12.15, '12 unidades de declicioso roll de salmon noruego','salmon_roll');
INSERT INTO `productos` (`COD_PRO`, `COD_SUB`, `NOMBRE`, `PRECIO`, `DESCRIPCION`, `URL_FOTO`) VALUES ('1407', '401', 'Dim Sum', 10.15, 'Delicioso plato japones','dim_sum');



INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Maikel', 'Pavones', 'Miguel', 'Villaespesa', 'C/ La alegria de la huerta', '330', '5', 'C','A', '28030', '630484672');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Grimgor', '123', 'Grimgor', 'Piel de Hierro', 'C/ Del gran wagh', '30', '5', 'C','2Der', '28030', '789684672');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Obama', '123', 'Barack', 'Obama', 'La Casa Blanca', '1', '5', 'C','Izq', '28030', '650684672');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Isabel II', '123', 'Elizabeth', 'Alexandra Mary', 'Buckingham Palace', '3', '5', 'C','Der', '28030', '680684672');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Luisito', '123', 'Luis', 'Vives', 'C/ Ermita', '15', '4' , 'c', '28030', '916659874');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Elenita', '123', 'Elena', 'de Troya', 'C/ Caballo de Troya', '20', '1', '2','Cen', '28030', '913254672');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Napo', '123', 'Napoleon', 'Bonaparte', 'Palacio de Fontainebleau', '1', '2', 'E','Izq', '28030', '996664422');
INSERT INTO `clientes` (`NOM_USER`, `PASS`, `NOMBRE`, `APELLIDOS`, `DIRECCION`, `NUMERO`, `PISO`, `LETRA`,`ESCALERA`,`COD_POSTAL`, `TELEFONO`) VALUES ('Leoncito', '123', 'Leonidas', 'Rey de Esparta', 'Termopilas', '1', '2', 'E','Izq', '28030', '976664422');

INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(100,'Leoncito','2014-03-14 18:27:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(101,'Maikel','2014-03-14 18:27:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(102,'Grimgor','2014-03-14 18:29:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(103,'Isabel II','2014-03-14 18:30:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(104,'Obama','2014-03-14 18:30:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(105,'Maikel','2014-03-14 18:31:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(106,'Elenita','2014-03-14 18:31:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(107,'Napo','2014-03-14 18:32:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(108,'Obama','2014-03-14 18:33:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(109,'Luisito','2014-03-14 18:34:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(110,'Maikel','2014-03-14 18:35:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(111,'Leoncito','2014-03-14 18:35:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(112,'Napo','2014-03-14 18:37:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(113,'Obama','2014-03-14 18:38:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(114,'Luisito','2014-03-14 18:39:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(115,'Maikel','2014-03-14 18:40:48');
INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES(116,'Napo','2014-03-14 18:50:48');

INSERT INTO `num_pedido` (`NUM_PEDIDO`, `NUM_PED`) VALUES ('A', 0);


INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(100,'1304',0,0,2,12.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(100,'1102',2,0,2,0);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(100,'1303',2,0,2,0);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(100,'1101',2,0,2,0);

INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(101,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(101,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(101,'703',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(101,'20',1,2.15,1,2.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(101,'1205',1,2.15,1,2.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(102,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(102,'1101',1,7.15,1,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(103,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(103,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(104,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(105,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(106,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(106,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(107,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(108,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(108,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(109,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(110,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(111,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(111,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(111,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(112,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(113,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(114,'1101',2,7.15,2,7.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(115,'1102',1,6.15,1,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(115,'1103',2,6.15,2,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'1102',4,6.15,4,6.15);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'23',2,1.80,2,1.80);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'22',2,1.80,2,1.80);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'1428',2,7.90,2,7.90);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'1425',2,10.90,2,10.90);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'288',1,4.10,1,4.10);
INSERT INTO `lin_ped`(`COD_PED`,`COD_PRO`,`CANTIDAD`,`PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`)VALUES(116,'280',2,5.50,2,5.50);



INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('1','50896360','Miguel','Villaespesa Cantalapiedra','Espanola','630484672');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('2','50896361','Frederik','Momi','Costa de Marfil','6301284672');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('3','50891456','Macarena','Malaguilla','Argentina','612317018');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('4','50123456','Isidro','Aurelio','Ecuador','612899018');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('5','12323456','Asdrubal','Vinicio','Peru','698799018');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('6','50891434','Raquel','Gutierrez','Espanola','674324218');
INSERT INTO `trabajadores`(`COD_TRA`,`DNI`,`NOMBRE`,`APELLIDOS`,`NACIONALIDAD`,`TELEFONO`)VALUES('7','51212434','Juan','Rosell','Espanola','674328218');

INSERT INTO `encargados`(`COD_TRA`,`PASS`) VALUES('3','4444');
INSERT INTO `encargados`(`COD_TRA`,`PASS`) VALUES('6','4444');
INSERT INTO `encargados`(`COD_TRA`,`PASS`) VALUES('7','123456');

INSERT INTO `repartidores`(`COD_TRA`,`DISPONIBLE`) VALUES('1','S');
INSERT INTO `repartidores`(`COD_TRA`,`DISPONIBLE`) VALUES('2','N');
INSERT INTO `repartidores`(`COD_TRA`,`DISPONIBLE`) VALUES('4','S');
INSERT INTO `repartidores`(`COD_TRA`,`DISPONIBLE`) VALUES('5','N');

INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(100,'3','2','2014-03-14 18:33:34', '2014-03-14 18:43:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(101,'3','1','2014-03-14 18:35:34', '2014-03-14 18:44:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(102,'3','1','2014-03-14 18:35:34', '2014-03-14 18:44:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(103,'3','2','2014-03-14 18:37:34', '2014-03-14 18:45:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(104,'3','4','2014-03-14 18:40:34', '2014-03-14 18:55:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(105,'3','5','2014-03-14 18:40:34', '2014-03-14 18:53:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(106,'3','1','2014-03-14 18:48:34', '2014-03-14 18:52:34');
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(107,'3','2','2014-03-14 18:52:34', null);
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(108,'3','2','2014-03-14 18:52:34', null);
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(109,'3','5','2014-03-14 18:54:34', null);
INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`,`HORA_LLEGADA`)VALUES(116,'6','1','2014-03-14 19:00:34', '2014-03-14 19:09:34');


INSERT INTO `incidencias`(`COD_INC`,`COD_TIC`,`DESCRIPCION`) VALUES(1,100,'El repartidor a sufrido un robo');


INSERT INTO `paginas_admin`(`id`,`orden`,`opcion`,`path`) VALUES( 1, 1,'Control Reparto','/admin/controlreparto');
INSERT INTO `paginas_admin`(`id`,`orden`,`opcion`,`path`) VALUES( 1, 2, 'Liquidacion','/admin/liquidacion');
INSERT INTO `paginas_admin`(`id`,`orden`,`opcion`,`path`) VALUES( 3, 3, 'Listar Reparto','/admin/listar-reparto');
INSERT INTO `paginas_admin`(`id`,`orden`,`opcion`,`path`) VALUES( 4, 4, 'Incidencias','/admin/incidencias');
INSERT INTO `paginas_admin`(`id`,`orden`,`opcion`,`path`) VALUES( 5, 5, 'Balance','/admin/balance');


