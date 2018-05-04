enum class Print(val header: String){
	PREORDER("Preorder:"),
	INORDER("In order:"),
	POSTORDER("Postorder:")
}


fun main(args: Array<String>){
	var root : IntNode? = null
	var input : Int?

	while (true) {
		if (root == null) {
			while (root == null) {
				print("Enter an integer value for the root node: ")
				try{
					input = readLine()?.toInt()
					if (input != null)
						root = IntNode(input)
				} catch (nfe : NumberFormatException){
					println("Invalid input for root.")
				}
			}
		}
		printUsage()
		try{
			input = readLine()?.toInt()
			if (input != null)
				when(input) {
					1 -> addPrompt(root)
					2 -> deletePrompt(root)
					3 -> searchPrompt(root)
					4 -> treeTraversal(root, Print.PREORDER)
					5 -> treeTraversal(root, Print.INORDER)
					6 -> treeTraversal(root, Print.POSTORDER)
					7 -> return
				}
		} catch (nfe : NumberFormatException) {
			println("Invalid input.")
		}
	}
}

fun addPrompt(root: IntNode){
	var node : IntNode? = null
	var input: Int?
	while (node == null) {
		try {
			println("Enter an integer value for the new node.")
			input = readLine()?.toInt()
			if (input != null)
				node = IntNode(input)
		} catch (nfe: NumberFormatException){
			println("Invalid input for new node.")
		}
	}
	root.addNode(node)
}

fun deletePrompt(root: IntNode){
	var input: Int? = null
	while (input == null) {
		try {
			println("Enter an integer value to delete from the tree.")
			input = readLine()?.toInt()

		} catch (nfe: NumberFormatException){
			println("Invalid input.")
		}
	}
	println(if (root.remove(input, null)) "$input was removed from the tree." else "$input is not contained in the tree.")
}

fun searchPrompt(root: IntNode){
	var input: Int? = null
	while (input == null) {
		try {
			println("Enter an integer value to search for.")
			input = readLine()?.toInt()

		} catch (nfe: NumberFormatException){
			println("Invalid input.")
		}
	}
	println(if (root.contains(input)) "$input is contained in the tree." else "$input is not contained in the tree.")
}

fun treeTraversal(root: IntNode, type: Print){
	println(type.header)
	when(type){
		Print.PREORDER -> root.preOrder()
		Print.INORDER -> root.inOrder()
		Print.POSTORDER -> root.postOrder()
	}
}

fun printUsage(){
    println("\n1.\tAdd a node to the tree.\n" +
    		"2.\tRemove a value from the tree.\n" +
    		"3.\tCheck if a value is contained in the tree.\n" +
    		"4.\tPrint tree in preorder.\n" +
    		"5.\tPrint tree in order.\n" +
    		"6.\tPrint tree in postorder.\n" +
    		"7.\tQuit.")
}