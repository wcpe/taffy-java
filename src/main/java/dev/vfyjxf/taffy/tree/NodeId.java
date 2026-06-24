package dev.vfyjxf.taffy.tree;

import java.util.Objects;

/**
 * A type representing the id of a single node in a tree of nodes.
 * Internally it is a wrapper around a long value.
 */
public final class NodeId {

    private final long value;

    public NodeId(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    /**
     * Create a new NodeId from a long value
     */
    public static NodeId of(long value) {
        return new NodeId(value);
    }

    /**
     * Get the ID (alias for getValue)
     */
    public long getId() {
        return value;
    }

    /**
     * Convert to int index
     */
    public int toIndex() {
        return (int) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeId that = (NodeId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NodeId[value=" + value + "]";
    }
}
