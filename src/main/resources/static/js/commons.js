/**
 * 
 */
$(function() {// 初始化内容
	
	  $("#toView").on("hide.bs.modal", function() {
	    	//alert("jjjs");
		    $(this).removeData('bs.modal');
	   });
	  
	  $("#update").on("hide.bs.modal", function() {
	    	//alert("jjjs");
		    $(this).removeData('bs.modal');
	   });
	  
	  
	    
	    $('#pay').on('show.bs.modal', function (event) {
	      //alert("哈哈");
	      var modal = $(this);  //get modal itself,先得到用户名
	      /*modal.find('.modal-body #message').text('your message');*/
	       var userName=modal.find('.modal-body #userName3').val();
	       //alert(userName);
	       modal.find('.modal-body #scan').attr("src", '../img/qr_'+userName+'.png');
	    });
	    
	    
	    //财务部门的支付
	    $('#financePay').on('show.bs.modal', function (event) {
		      alert("哈哈");
		      var modal = $(this);  //get modal itself,先得到用户名
		      //modal.find('.modal-body #message').text('your message');
		       var img4=modal.find('.modal-body #img4').val();
		       //alert(img4);
		       modal.find('.modal-body #scan1').attr("src", img4);
		    });

	    
		//进行给我们的全选/全不选控件设置一个点击事件
		$("#allCheck").click(function(){
			//进行开发我们的全选操作
			//得到我们的所有的点击checkbox的控件
			//$("tbody input").attr("checked",this.checked);//这个方法在我们的jquery的1.1中是这个方法是有bug的,但是在1.1中提拱了prop的这个方法
			  $("tbody input").prop("checked",this.checked);
		});
		
		$("#exportFinanceDepartment").click(function(){

             var arr = new Array();
             $(":checkbox:checked").each(function(i){
            	 var d=$(this).val();
            	 //alert(i)
            	 if(i==0){
            		 if(d=='on'){
            			 
            		 }else{
            			 arr[i] = $(this).val();  
            		 }
            		 
            	 }else{
            		 //alert(d);
            		 arr[i-1] = $(this).val();   
            	 }
            	 
            	          
             });
             var vals = arr.join(",");
             alert(vals);
             //给服务器请求发送数据
             window.location.href ="http://localhost:8080/OrderBook/ReportFinanceDepartment.action?bookIds="+vals;
             //window.location.href = "http://www.accpweb.com"
			 return false;
		});
	  
		
		//支付和上报功能模块
		$("#exportPurchasingDepartment").click(function(){
			var arr = new Array();
            $(":checkbox:checked").each(function(i){
           	 var d=$(this).val();
           	 //alert(i)
           	 if(i==0){
           		 if(d=='on'){
           			 
           		 }else{
           			 arr[i] = $(this).val();  
           		 }
           		 
           	 }else{
           		 //alert(d);
           		 arr[i-1] = $(this).val();   
           	 }
           	 
           	          
            });
            var vals = arr.join(",");
            //alert(vals);
            //给服务器请求发送数据
            //window.location.href ="http://localhost:8080/purchaseDepartment/exportPurchasingDepartment.action?bookIds="+vals;
            
            //先发送ajax请求去获取数据
            
            $.ajax({
            	  url: "/OrderBook/getTotalMoney.action",
            	  data:"bookIds="+vals,
            	  cache: false,
            	  type: "POST",
            	  dataType:"json",
            	  success: function(data){
            	    alert(data.imgPath+"::"+data.totalMoney);
            		$('#bookId4').val(vals);
            		$('#img4').val(data.imgPath);
            	    
            	  }
            	});
            
            
            
            //window.location.href = "http://www.accpweb.com"
			//return false;
		});
		
		
		//完成finishPurchased
		    //finishPurchased
		/*$("#finishPurchased1").click(function(){
			alert("click方法调用了...");
			var arr = new Array();
            $(":checkbox:checked").each(function(i){
           	 var d=$(this).val();
           	 //alert(i)
           	 if(i==0){
           		 if(d=='on'){
           			 
           		 }else{
           			 arr[i] = $(this).val();  
           		 }
           		 
           	 }else{
           		 //alert(d);
           		 arr[i-1] = $(this).val();   
           	 }
           	 
           	          
            });
            var vals = arr.join(",");
            //alert(vals);
            //给服务器请求发送数据												    
            window.location.href ="http://localhost:8080/purchaseDepartment/finishPurchased.action?ids="+vals;
            //window.location.href = "http://www.accpweb.com"
			return false;

		});
	  */
});


//支付的功能的方法
function payFunction(Idt){
	alert(Idt);
	var ids=Idt.split("---");
	var bookId=ids[0];
	userName=ids[1];
	$('#bookId3').val(bookId);
	$('#userName3').val(userName);
}



function addOrderBook(){
	alert("哈哈");
}
 
		//提交更改  
function toView(ids) {  
	//alert("toView方法被调用了..."+ids);
	//alert(typeof(ids));
	var idt=ids.split("---");
	var id=idt[0];
	var flag=idt[1];
	
    //alert(id);
	
	
     //获取表格中的一行数据  
    var bookName = document.getElementById("table").rows[id].cells[0].innerText;
    /*  alert(bookName); */
    //alert("toView方法被调用了..."+id+"::"+bookName);
    var userName = document.getElementById("table").rows[id].cells[1].innerText;  
    var author = document.getElementById("table").rows[id].cells[2].innerText;  
    var publish = document.getElementById("table").rows[id].cells[3].innerText;  
    var barcode = document.getElementById("table").rows[id].cells[4].innerHTML; 
   /*  var bb=barcode.split("src="); */
    //alert("toView方法被调用了::"+barcode);
    var price = document.getElementById("table").rows[id].cells[5].innerText;
    var number = document.getElementById("table").rows[id].cells[6].innerText; 
    var totalNumber = document.getElementById("table").rows[id].cells[7].innerText; 
	//alert(bookId+"::"+bookName+":"+userName+":"+author+":"+publish+":条形码"+barcode+":"+price);
	if(flag==1){
		//alert("1");
		var bookId=idt[2];
		//alert(bookId);
		$('#bookId2').val(bookId);
	    $('#bookName2').val(bookName);
	    $('#userName2').val(userName);  
	    $('#author2').val(author);
	    $('#publish2').val(publish); 
	   /* $('#barcode2').append(barcode); *///会持续的增加，没有清空
	    $('#barcode2').html(barcode); //每次都进行清空，然后再进行增加
	    $('#price2').val(price);
	    $('#number2').val(number);
	    $('#totalNumber2').val(totalNumber);

	}else{
	    $('#bookName1').val(bookName);
	    $('#userName1').val(userName);  
	    $('#author1').val(author);
	    $('#publish1').val(publish); 
	    $('#barcode1').html(barcode); 
	    $('#price1').val(price);
	    $('#number1').val(number);
	    $('#totalNumber1').val(totalNumber);
	}
}  


function adminCheck(idt){
	var ids=idt.split("---");
	var id=ids[0];
	var bookId=ids[1];
	//alert(id);
	//获取表格中的一行数据  
    var bookName = document.getElementById("table").rows[id].cells[1].innerText;

    var userName = document.getElementById("table").rows[id].cells[2].innerText;  
    
    var price = document.getElementById("table").rows[id].cells[3].innerText;
    var number = document.getElementById("table").rows[id].cells[4].innerText; 
    var totalNumber = document.getElementById("table").rows[id].cells[5].innerText; 
    var payStatus = document.getElementById("table").rows[id].cells[6].innerText; 
    
	$('#bookId3').val(bookId);
    $('#bookName3').val(bookName);
    $('#userName3').val(userName);  

    $('#price3').val(price);
    $('#number3').val(number);
    $('#totalNumber3').val(totalNumber);
    $('#payStatus3').val(payStatus);  
    
    //alert(bookId);
}

function financeCheck(idt){
	var ids=idt.split("---");
	var id=ids[0];
	var bookId=ids[1];
	//alert(id);
	//获取表格中的一行数据  
    var bookName = document.getElementById("table").rows[id].cells[1].innerText;

    var userName = document.getElementById("table").rows[id].cells[2].innerText;  
    
    var price = document.getElementById("table").rows[id].cells[3].innerText;
    var number = document.getElementById("table").rows[id].cells[4].innerText; 
    var totalNumber = document.getElementById("table").rows[id].cells[5].innerText; 
    var payStatus = document.getElementById("table").rows[id].cells[6].innerText; 
    
	$('#bookId4').val(bookId);
    $('#bookName4').val(bookName);
    $('#userName4').val(userName);  

    $('#price4').val(price);
    $('#number4').val(number);
    $('#totalNumber4').val(totalNumber);
    $('#payStatus4').val(payStatus);  
	
	
}


function updateFinishOrder(){
	
	alert("中国，testttt");
	var arr = new Array();
    $(":checkbox:checked").each(function(i){
   	 var d=$(this).val();
   	 //alert(i)
   	 if(i==0){
   		 if(d=='on'){
   			 
   		 }else{
   			 arr[i] = $(this).val();  
   		 }
   		 
   	 }else{
   		 //alert(d);
   		 arr[i-1] = $(this).val();   
   	 }
   	 
   	          
    });
    var vals = arr.join(",");
    alert(vals);
    //给服务器请求发送数据
    window.location.href ="http://localhost:8080/purchaseDepartment/finishPurchasedTest.action?ids="+vals;
    //window.location.href = "http://www.accpweb.com"
	return false;

}