package dev.vfyjxf.taffy.tree;

import dev.vfyjxf.taffy.geometry.FloatPoint;
import dev.vfyjxf.taffy.geometry.FloatRect;
import dev.vfyjxf.taffy.geometry.FloatSize;

import java.util.Objects;

/**
 * The final result of a layout algorithm for a single node.
 *
 * @param order         The relative ordering of the node. Nodes with a higher order should be rendered on top.
 * @param location      The top-left corner of the node
 * @param size          The width and height of the node
 * @param contentSize   The width and height of the content inside the node.
 *                      This may be larger than the size of the node in the case of overflowing content.
 * @param scrollbarSize The size of the scrollbars in each dimension. If there is no scrollbar then the size will be zero.
 * @param border        The size of the borders of the node
 * @param padding       The size of the padding of the node
 * @param margin        The size of the margin of the node
 */
public final class Layout {

    private final int order;
    private final FloatPoint location;
    private final FloatSize size;
    private final FloatSize contentSize;
    private final FloatSize scrollbarSize;
    private final FloatRect border;
    private final FloatRect padding;
    private final FloatRect margin;

    public Layout(
        int order,
        FloatPoint location,
        FloatSize size,
        FloatSize contentSize,
        FloatSize scrollbarSize,
        FloatRect border,
        FloatRect padding,
        FloatRect margin
    ) {
        this.order = order;
        this.location = location;
        this.size = size;
        this.contentSize = contentSize;
        this.scrollbarSize = scrollbarSize;
        this.border = border;
        this.padding = padding;
        this.margin = margin;
    }

    /**
     * Creates a new zero-Layout
     */
    public Layout() {
        this(0, FloatPoint.zero(), FloatSize.zero(), FloatSize.zero(), FloatSize.zero(), FloatRect.zero(), FloatRect.zero(), FloatRect.zero());
    }

    /**
     * Creates a new zero-Layout with the supplied order value
     */
    public Layout(int order) {
        this(order, FloatPoint.zero(), FloatSize.zero(), FloatSize.zero(), FloatSize.zero(), FloatRect.zero(), FloatRect.zero(), FloatRect.zero());
    }

    /**
     * Creates a new Layout with the given order
     */
    public static Layout withOrder(int order) {
        return new Layout(order);
    }

    /**
     * Copy constructor
     */
    public Layout copy() {
        return new Layout(
            order,
            location.copy(),
            size.copy(),
            contentSize.copy(),
            scrollbarSize.copy(),
            border.copy(),
            padding.copy(),
            margin.copy()
        );
    }

    /**
     * Get the width of the node's content box
     */
    public float contentBoxWidth() {
        return size.width - padding.left - padding.right - border.left - border.right;
    }

    /**
     * Get the height of the node's content box
     */
    public float contentBoxHeight() {
        return size.height - padding.top - padding.bottom - border.top - border.bottom;
    }

    /**
     * Get the size of the node's content box
     */
    public FloatSize contentBoxSize() {
        return new FloatSize(contentBoxWidth(), contentBoxHeight());
    }

    /**
     * Get x offset of the node's content box relative to its parent's border box
     */
    public float contentBoxX() {
        return location.x + border.left + padding.left;
    }

    /**
     * Get y offset of the node's content box relative to its parent's border box
     */
    public float contentBoxY() {
        return location.y + border.top + padding.top;
    }

    /**
     * Return the scroll width of the node.
     */
    public float scrollWidth() {
        return Math.max(0, contentSize.width + Math.min(scrollbarSize.width, size.width)
                           - size.width + border.right);
    }

    /**
     * Return the scroll height of the node.
     */
    public float scrollHeight() {
        return Math.max(0, contentSize.height + Math.min(scrollbarSize.height, size.height)
                           - size.height + border.bottom);
    }

    // === Getter methods ===

    public int order() {
        return order;
    }

    public FloatPoint location() {
        return location;
    }

    public FloatSize size() {
        return size;
    }

    public FloatSize contentSize() {
        return contentSize;
    }

    public FloatSize scrollbarSize() {
        return scrollbarSize;
    }

    public FloatRect border() {
        return border;
    }

    public FloatRect padding() {
        return padding;
    }

    public FloatRect margin() {
        return margin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layout other = (Layout) o;
        return order == other.order
               && Objects.equals(location, other.location)
               && Objects.equals(size, other.size)
               && Objects.equals(contentSize, other.contentSize)
               && Objects.equals(scrollbarSize, other.scrollbarSize)
               && Objects.equals(border, other.border)
               && Objects.equals(padding, other.padding)
               && Objects.equals(margin, other.margin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, location, size, contentSize, scrollbarSize, border, padding, margin);
    }

    @Override
    public String toString() {
        return "Layout[order=" + order + ", location=" + location + ", size=" + size
               + ", contentSize=" + contentSize + ", scrollbarSize=" + scrollbarSize
               + ", border=" + border + ", padding=" + padding + ", margin=" + margin + "]";
    }
}
