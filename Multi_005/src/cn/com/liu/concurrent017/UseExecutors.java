package cn.com.liu.concurrent017;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class UseExecutors {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		//cache fixed single
		System.out.println(pool);
		
		pool.submit(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("线程1");
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		pool.submit(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("线程2");
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		int count = 0;
		while(true){
			System.out.println(count);
			try {
				TimeUnit.SECONDS.sleep(1);
				count++;
				if(count==20){
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
	}
}
