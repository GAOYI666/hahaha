
import java.awt.Color;
import java.awt.Graphics;
import  java.lang.Math ;
public class ComThink {
private int x ; 
private int y ;
private int[][] chessArray ;
int[][] BoxesArray ;
ComThink(){}
ComThink(int[][] a ,int[][] b ){
	chessArray 	= a ;
	BoxesArray 	= b ;
	nextstep() ; 
}
//获得X值
public int getX(){
	return x ;
}
//获得y值
public int getY(){
	return y ;
}
//轮盘法
public void nextstep(){
	boolean threeflag;//判断有误自由度为1的
	threeflag=false;
	for(int i=0;i<11;i++){
		for(int j=0;j<11;j++){
			if(chessArray[i][j]==3){
				if(chessArray[i+1][j]==1){this.x=i+1;this.y=j;}
				else if(chessArray[i-1][j]==1){this.x=i-1;this.y=j;}
				else if(chessArray[i][j+1]==1){this.x=i;this.y=j+1;}
				else {this.x=i;this.y=j-1;}
				threeflag=true ;
			}
		}
	}
	int leftlines = 0 ;
	int s  = 0 	;
	int a = 0 ; 
	boolean flag=true;
	if(threeflag==false){
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				if(chessArray[i][j]==1&&( (i%2==1&&j%2==0) || (i%2==0&&j%2==1) )){
					leftlines++ ;
				}
			}
		}
		s= (int) (Math.random() * (leftlines+1) ) ;
		System.out.println(leftlines);
		for(int i=0;i<chessArray.length;i++){
			for(int j=0;j<chessArray[i].length;j++){
				if(chessArray[i][j]==1&&( (i%2==1&&j%2==0) || (i%2==0&&j%2==1) )){
					a ++ ;
			if(a==s){
						this.x = i ;
						this.y = j ;
						//flag=false;
						break ;
					}
				}
		}
	}}
}
}