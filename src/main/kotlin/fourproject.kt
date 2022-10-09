import java.lang.Double.max
import java.lang.Double.min

class Point(val x:Double, val y:Double) // 한줄 클래스 정의. 가능한 주생성자를 쓰는 것이 좋다.

class Rectangle(left:Double,right:Double,bottom:Double,top:Double ){
    val left = left
    val right = right
    val bottom = bottom
    val top = top

    constructor(p1:Point, p2:Point):this(min(p1.x,p2.x),max(p1.x,p2.x),min(p1.y,p2.y),max(p1.y,p2.y)){
            if(p1.x>=p2.x || p1.y>=p2.y) {
                throw IllegalArgumentException("")
            }
    }




    fun overlappingRectangle(r:Rectangle):Rectangle{
        //겹치지 않을 경우 NoSuchElementException을 발생
        if(left>=r.right || right<=r.left || top<=r.bottom || bottom>=r.top){
            throw NoSuchElementException("")
        }
        else{
           return Rectangle(max(left,r.left),max(right,r.right),max(bottom,r.bottom),max(top,r.top))
        }
    }

    fun printRectangle(){
        println("결과:\n직사각형 좌:${left.toInt()}, 우:${right.toInt()}, 하:${bottom.toInt()}, 상:${top.toInt()}")
    }

}


fun main() {
    try {
        println("직사각형 1의 대각점 1의 좌표를 입력하시오: ")
        val p1X = readLine()!!.toDouble()
        val p1Y = readLine()!!.toDouble()
        println("직사각형 1의 대각점 2의 좌표를 입력하시오: ")
        val p2X = readLine()!!.toDouble()
        val p2Y = readLine()!!.toDouble()
        val r1 = Rectangle(Point(p1X, p1Y), Point(p2X, p2Y))
        println("직사각형 2의 대각점 1의 좌표를 입력하시오: ")
        val p3X = readLine()!!.toDouble()
        val p3Y = readLine()!!.toDouble()
        println("직사각형 1의 대각점 2의 좌표를 입력하시오: ")
        val p4X = readLine()!!.toDouble()
        val p4Y = readLine()!!.toDouble()
        val r2 = Rectangle(Point(p3X, p3Y), Point(p4X, p4Y))
        r1.overlappingRectangle(r2).printRectangle()
    } catch (e: IllegalArgumentException) {
        println("직사각형이 잘못 입력되었습니다.")
    } catch (e: NoSuchElementException) {
        println("직사각형이 겹치지 않습니다.")
    }

}