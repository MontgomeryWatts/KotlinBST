class IntNode(var data: Int, var left: IntNode?, var right: IntNode?){
    constructor(data: Int): this(data, null, null)

    fun addNode(node: IntNode){
        if (node.data <= this.data) {
            if (left != null)
                left?.addNode(node)
            else
                left = node
        }
        else {
            if (right != null)
                right?.addNode(node)
            else
                right = node
        }
    }

    fun contains(target: Int) : Boolean {
        if (data != target){
            if (target < data)
                return left?.contains(target) ?: false
            else
                return right?.contains(target) ?: false
        }
        return true
    }

    fun findMinValue() : Int {
        return left?.findMinValue() ?: data
    }

    fun inOrder(){
        left?.inOrder()
        println(data)
        right?.inOrder()
    }

    fun preOrder(){
        println(data)
        left?.preOrder()
        right?.preOrder()
    }

    fun postOrder(){
        left?.postOrder()
        right?.postOrder()
        println(data)
    }

    fun remove(target: Int, parent: IntNode?) : Boolean {
        if (data != target){
            if (target < data)
                    return left?.remove(target, this) ?: false
            else
                return right?.remove(target, this) ?: false
        }
        else{
            if (left != null && right != null) { //Current node has two children
                val newData = right?.findMinValue() ?: data //right should never be null, but Kotlin null-safety
                data = newData
                right?.remove(data, this)

            }
            else if (left != null || right != null){ //Current node has one child
                val child = left ?: right
                if (parent != null)
                    if(parent.left == this){
                        parent.left = child
                    }
                    else
                        parent.right = child
            }
            else{ //Current node has no children
                if (parent != null)
                    if(parent.left == this){
                        parent.left = null
                    }
                    else
                        parent.right = null
            }
        }
        return true
    }

}