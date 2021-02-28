package file.system.exercise.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Node implements Comparable<Node> {
	private String name;
	private Set<Node> children = new TreeSet<>();
	private Set<File> files = new TreeSet<>();
	private Node previous;

	public Node(String nodeName) {
		this.name = nodeName;
	}

	public Set<Node> getChildren() {
		return children;
	}

	public boolean addChild(Node node) {
		node.previous = this;
		return this.children.add(node);
	}

	public Set<File> getFiles() {
		return files;
	}

	public boolean addFile(File file) {
		return this.files.add(file);
	}

	public String getName() {
		return name;
	}

	public Node getPrevious() {
		return previous;
	}

	public Node getRoot(Node node) {
		if (this.previous == null)
			return this;
		System.err.println("stak");
		return getRoot(node);
	}

	@Override
	public String toString() {
		return String.format("%s", this.name);
	}

	@Override
	public int compareTo(Node o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Node node = (Node) obj;
		return Objects.equals(name, node.getName());
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
