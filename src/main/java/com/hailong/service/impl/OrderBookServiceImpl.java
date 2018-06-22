package com.hailong.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailong.dao.OrderBookDao;
import com.hailong.domain.OrderBook;
import com.hailong.domain.User;
import com.hailong.service.OrderBookService;
import com.hailong.utils.BarCodeUtils;

@Service
public class OrderBookServiceImpl implements OrderBookService{
	
	//注入OrderBookDao层的对象
	@Autowired
	private OrderBookDao<OrderBook> orderBookDao;
	
/*	//注入activity相关的service层对象
	@Autowired
	private RepositoryService repositoryService;
	
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;*/

	@Override
	public List<OrderBook> findAll() {

		return orderBookDao.findAll();
	}

	@Override
	public OrderBook findOne(String bookId) {
		return orderBookDao.findOne(bookId);
	}
	
	/**
	 * 	增加图书数据
	 *  如果map数据增加成功，则返回null
	 */
	
	 public OrderBook addOrderBook(OrderBook ob,HttpServletRequest request) {
		String bookName=ob.getBookName();
		if(bookName!=null&&!"".equals(bookName)){
			User user=(User) request.getSession().getAttribute("currentUser");
			if(user!=null){
				//进行自动生成图书ID和条形码
				ob.setBookId(UUID.randomUUID().toString());
				ob.setBarcode(BarCodeUtils.makeBarCode(bookName));
				ob.setUserName(user.getUsername());
				//在类加载的路径下生成一个二维码
				BarCodeUtils.makeQRCode(user.getUsername());
				
				//放入容器当中
				OrderBook orderBook=orderBookDao.addOrderBook(ob);
				if(orderBook==null){
					return ob;
				}
				return null;
			}
			
		}
		return null;
	}

	@Override
	public OrderBook deleteOrderBook(String bookId) {
		if(bookId!=null&&!"".equals(bookId)){
			return orderBookDao.deleteOrderBook(bookId);
		}
		return null;
	}

	//更新方法
	@Override
	public OrderBook updateOrderBook(OrderBook ob) {
		String bookId=ob.getBookId();
		if(bookId!=null&&!"".equals(bookId)){
			//进行重新生成一个条形码
			ob.setBarcode(BarCodeUtils.makeBarCode(ob.getBookName()));
			//进行调用Dao层的方法
			return orderBookDao.updateOrderBook(ob);
		}
		return null;
	}

	@Override
	public boolean updatePay(String bookId) {
		//根据Id来查询具体的OB对象
		OrderBook ob=orderBookDao.findOne(bookId);
		if(ob!=null){
			//则查询成功
			ob.setPayStatus("1");//1则为已支付状态
			//进行先删除数据，然后再加入
			orderBookDao.deleteOrderBook(bookId);
			//加入到数据当中
			orderBookDao.addOrderBook(ob);
			return true;
			
		}
		return false;
	}

	@Override
	public boolean updateStatus(String bookId) {
		//根据Id来查询具体的OB对象
		OrderBook ob=orderBookDao.findOne(bookId);
		if(ob!=null){
			//则查询成功
			ob.setStatus("1");// 1则为已下单状态
			//进行先删除数据，然后再加入
			orderBookDao.deleteOrderBook(bookId);
			//加入到数据当中
			orderBookDao.addOrderBook(ob);
			
			return true;
			
		}
		return false;
	}
	
/*
	@Override
	public Deployment DeploymentOrderProcess() {
		InputStream OrderIn=this.getClass().getClassLoader().getResourceAsStream("processes/orderProcess.zip");
		ZipInputStream in=new ZipInputStream(OrderIn);
		//成功，则进行布著订单流程数据
		Deployment deploy=repositoryService.createDeployment().name("开始订购流程")
		                 .addZipInputStream(in)
		                 .deploy();
		return deploy;
	}

	@Override
	public ProcessInstance startProcessInstance() {
		//成功,开启流程实例
		ProcessInstance proInstance=runtimeService.startProcessInstanceByKey("OrderProcess");
		String deploymentId=proInstance.getDeploymentId();
		String taskId=taskService.createTaskQuery().deploymentId(deploymentId).singleResult().getTaskDefinitionKey();
		if(taskId!=null&&!"".equals(taskId)){
			//然后进行完成当前的任务
			completeTask(taskId);
		}
		return proInstance;
		
	}

	//完成当前的任务,也就是办理个人任务
	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	public void WatchProcessImage(String deploymentId,String imageResourceName,HttpServletResponse response) {
			InputStream in=repositoryService.getResourceAsStream(deploymentId,imageResourceName);
			OutputStream out=null;
			//设置响应的数据的类型,不是下载类型
			response.setContentType("image/png");
			int len=-1;
			//数组当中的数据内容
			byte[] buffer=new byte[4096];
			try {
				//如果是一些字节的数据信息，只能是使用字节流
				out=response.getOutputStream();
				while((len=in.read(buffer))!=-1){
					out.write(buffer,0,len);//写出数据
				}
			} catch (IOException e) {
				e.printStackTrace();
		    }finally{
		    	try {
		    		if(in!=null){
		    			in.close();
		    		}
		    		if(out!=null){
		    			out.close();
		    		}
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	}

	@Override
	public void getAllNoCompleteTask() {
		List<Task> ListTask=taskService.createTaskQuery().list();
		for(Task task:ListTask){
			System.out.println("办理人:"+task.getAssignee());
			System.out.println("指定任务定义Id:"+task.getTaskDefinitionKey());
			System.out.println("办理名称:"+task.getName());
			System.out.println("任务的执行Id:"+task.getExecutionId());
			//System.out.println("");
		}
	}

	@Override
	public List<Task> getPersonTask() {
		List<Task> ListTask=taskService.createTaskQuery().taskName("老师或学生").list();
		for(Task task:ListTask){
			System.out.println("办理人:"+task.getAssignee());
			System.out.println("指定任务定义Id:"+task.getTaskDefinitionKey());
			System.out.println("办理名称:"+task.getName());
			System.out.println("任务的执行Id:"+task.getExecutionId());
			//System.out.println("");
		}
		return ListTask;
	}
*/
}
