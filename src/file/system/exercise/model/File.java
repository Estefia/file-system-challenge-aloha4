package file.system.exercise.model;

import java.util.Objects;

public class File implements Comparable<File>{
	private String name;

	public File(String fileName) {
		this.name = fileName;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s", this.name);
	}

	@Override
	public int compareTo(File o) {
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