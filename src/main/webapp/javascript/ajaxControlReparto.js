$(document).ready(function() {        
	$.get('../AjaxMostrarPantallaReparto',function(responseText) { 
		$('#reparto').html(responseText);         
	});
});

function asignarReparto(cod_tra){
	var pedidos = document.getElementsByName('pedidos');
	var pedidosSeleccionados = new Array();
	var cont = 0;
	for (var i=0; i < pedidos.length; i++) {
		 if (pedidos[i].checked) {
			 pedidosSeleccionados.push(pedidos[i].value);
			 cont++;
		 }
	}
	if (cont>0) {
		$.get('../AsignarRepartoAjax',{cod_tra:cod_tra,pedido1:pedidosSeleccionados[0],pedido2:pedidosSeleccionados[1]},function(responseText) { 
			$('#mensajesControlReparto').html(responseText);   
			$.get('../AjaxMostrarPantallaReparto',function(responseText) { 
				$('#reparto').html(responseText);         
			});
		});
		
	}else{
		$('#mensajesControlReparto').html("<h2>Tiene que seleccionar un pedido antes</h2>"); 
	}
}

function desasignarReparto(cod_tra){
	$.get('../DesAsignarReparto',{cod_tra:cod_tra},function(responseText) { 
		$('#mensajesControlReparto').html(responseText);     
		$.get('../AjaxMostrarPantallaReparto',function(responseText) { 
			$('#reparto').html(responseText);         
		});
	});
}

function controlDosChecked(){
	var pedidos = document.getElementsByName('pedidos');
	var cont = 0;
	for (var i=0; i < pedidos.length; i++) {
		 if (pedidos[i].checked) {
			  cont = cont + 1;
		 }
	}

	if(cont >= 2){
		for (var i=0; i < pedidos.length; i++) {
			 if (!pedidos[i].checked) {
				 pedidos[i].disabled = true;
				 pedidos[i].parentNode.parentNode.className='disable';
			 }
		}
	}else{
		for (var i=0; i < pedidos.length; i++) {
			 pedidos[i].disabled = false;
			 pedidos[i].parentNode.parentNode.className="ck-button";
		}
	}
}