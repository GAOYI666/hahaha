import java.awt.Color;
import java.awt.Graphics;
public class zuobiao {
	private int x ;           			 //x����
	private  int y ;					//y����
	zuobiao(int x1,int y1){          		// ��������
		int x2=0;
		int y2=0;
		x2 = x1/40;
		y2 = y1/40;
		if(x1%40==x1%80){
		    if(x2*40+20<x1 && x1<x2*40+40 && y2*40<y1 && y1<y2*40+20){
				x = x2+1;
				y = y2;
		    }
	   }else {
			if(x2*40<x1 && x1<x2*40+40 && y2*40<y1 && y1 <y2*40+20){
					 x = x2;
					 y = y2;
			}
		}
			if(y1%40==y1%80){
				 if(x2*40<x1 && x1<x2*40+20 && y2*40+20<y1 && y1<y2*40+40){
					 x = x2 ;
					 y = y2 + 1 ;
				 }
			 }else {
				 if(x2*40<x1 && x1<x2*40+20 && y2*40<y1 && y1<y2*40+40){
					 x = x2 ;
					 y = y2 ;
				 }
			 }
		}
	
		public int getX(){    //���x����
			return x ;
		}
		public int getY(){    //���y����
			return y ;
		}
}

			// TODO Auto-generated method stub
			
		