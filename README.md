# SSCCE Demo of Drag n Drop Error

Note: license has been omitted from this repo.  Add the license in the JXB_LICENSE constant in App.java.

Given this project, dragging Swing elements, as well as files from the Desktop such as .svg result in the following error as soon as the draggable item enters (drag-enter) the panel.

```stacktrace

java.lang.NullPointerException
	at com.teamdev.jxbrowser.view.swing.internal.dnd.DragAndDropHelper$DropListener.updateDragOperation(DragAndDropHelper.java:243)
	at com.teamdev.jxbrowser.view.swing.internal.dnd.DragAndDropHelper$DropListener.dragOver(DragAndDropHelper.java:272)
	at java.desktop/java.awt.dnd.DropTarget.dragOver(DropTarget.java:379)
	at java.desktop/sun.awt.dnd.SunDropTargetContextPeer.processMotionMessage(SunDropTargetContextPeer.java:482)
	at java.desktop/sun.lwawt.macosx.CDropTargetContextPeer.processMotionMessage(CDropTargetContextPeer.java:95)
	at java.desktop/sun.awt.dnd.SunDropTargetContextPeer$EventDispatcher.dispatchMotionEvent(SunDropTargetContextPeer.java:835)
	at java.desktop/sun.awt.dnd.SunDropTargetContextPeer$EventDispatcher.dispatchEvent(SunDropTargetContextPeer.java:781)
	at java.desktop/sun.awt.dnd.SunDropTargetEvent.dispatch(SunDropTargetEvent.java:48)
	at java.desktop/java.awt.Component.dispatchEventImpl(Component.java:4873)
	at java.desktop/java.awt.Container.dispatchEventImpl(Container.java:2321)
	at java.desktop/java.awt.Component.dispatchEvent(Component.java:4840)
	at java.desktop/java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4918)
	at java.desktop/java.awt.LightweightDispatcher.processDropTargetEvent(Container.java:4621)
	at java.desktop/java.awt.LightweightDispatcher.dispatchEvent(Container.java:4483)
	at java.desktop/java.awt.Container.dispatchEventImpl(Container.java:2307)
	at java.desktop/java.awt.Window.dispatchEventImpl(Window.java:2772)
	at java.desktop/java.awt.Component.dispatchEvent(Component.java:4840)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:772)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:95)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:745)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:743)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:742)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)


```
