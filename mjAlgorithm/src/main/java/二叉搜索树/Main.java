package 二叉搜索树;

import 二叉搜索树.printer.BinaryTreeInfo;
import 二叉搜索树.printer.BinaryTrees;

import java.nio.file.Files;
import java.util.Comparator;



@SuppressWarnings("unused")
public class Main {
	


	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
	}
	

	
	static void test4() {
		BinaryTrees.println(new BinaryTreeInfo() {
			
			@Override
			public Object string(Object node) {
				return node.toString() + "_";
			}
			
			@Override
			public Object root() {
				return "A";
			}
			
			@Override
			public Object right(Object node) {
				if (node.equals("A")) return "C";
				if (node.equals("C")) return "E";
				return null;
			}
			
			@Override
			public Object left(Object node) {
				if (node.equals("A")) return "B";
				if (node.equals("C")) return "D";
				return null;
			}
		});
		
		// test3();
		
		
		/*
		 * Java的匿名类，类似于iOS中的Block、JS中的闭包（function）
		 */
		
//		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return 0;
//			}
//		});
//		bst1.add(new Person(12));
//		bst1.add(new Person(15));
//		
//		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
//
		
		
//		BinarySearchTree<Car> bst4 = new BinarySearchTree<>(new Car);
//		
//		
//		java.util.Comparator<Integer> iComparator;
	}
	
	static void test5() {
		BinarySearchTree<Person> bst = new BinarySearchTree<>();
		bst.add(new Person(10, "jack"));
		bst.add(new Person(12, "rose"));
		bst.add(new Person(6, "jim"));
		
		bst.add(new Person(10, "michael"));
		
		BinaryTrees.println(bst);
	}
	
	static void test6() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
//		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		for (int i = 0; i < 10; i++) {
//			bst.add((int)(Math.random() * 100));
//		}
		BinaryTrees.println(bst);
		System.out.println(bst.isComplete());
		
		// bst.levelOrderTraversal();
		
		/*
		 *       7
		 *    4    9
		    2   5
		 */
		
//		bst.levelOrder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + element + "_ ");
//			}
//		});
		
//		bst.inorder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + (element + 3) + "_ ");
//			}
//		});
		
		// System.out.println(bst.height());
	}
	
	static void test7() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		bst.remove(7);
		
		BinaryTrees.println(bst);
	}
	
	static void test8() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		System.out.println(bst.isComplete());
	}
	
	static void test9() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		
		bst.preorder(new BinarySearchTree.Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 2 ? true : false;
			}
		});
		System.out.println();
		
		bst.inorder(new BinarySearchTree.Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		System.out.println();
		
		bst.postorder(new BinarySearchTree.Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		System.out.println();
		
		bst.levelOrder(new BinarySearchTree.Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 9 ? true : false;
			}
		});
		System.out.println();
	}
	
	public static void main(String[] args) {
		test5();
	}
}
