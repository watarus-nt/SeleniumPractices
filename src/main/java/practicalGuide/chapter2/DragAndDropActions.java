package practicalGuide.chapter2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tranmanhhung on 8/6/2017.
 */
public class DragAndDropActions extends MouseBasedInteractions {

    private WebElement draggable;
    private WebElement droppable;

    public DragAndDropActions() {
        super();
    }

    public static void main(String args[]) {
        DragAndDropActions dragAndDropActions = new DragAndDropActions();

        String htmlFile = dragAndDropActions.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\DragMe.html";
        System.out.println("htmlFile = " + htmlFile);

        dragAndDropActions.setDraggable(dragAndDropActions.getDriver().findElement(By.id("draggable")));
        dragAndDropActions.dragAndDropByExample();


        htmlFile = dragAndDropActions.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\DragAndDrop.html";
        System.out.println("htmlFile = " + htmlFile);

        dragAndDropActions.setDraggable(dragAndDropActions.getDriver().findElement(By.id("draggable")));
        dragAndDropActions.setDroppable(dragAndDropActions.getDriver().findElement(By.id("droppable")));

        dragAndDropActions.dragAndDropExample();

    }

    public WebElement getDraggable() {
        return draggable;
    }

    public void setDraggable(WebElement draggable) {
        this.draggable = draggable;
    }

    public WebElement getDroppable() {
        return droppable;
    }

    public void setDroppable(WebElement droppable) {
        this.droppable = droppable;
    }

    public void dragAndDropByExample() {
        Actions builder = new Actions(getDriver());
        builder.dragAndDropBy(getDraggable(), 500, 100)
                .perform();
    }

    public void dragAndDropExample() {
        Actions builder = new Actions(getDriver());
        builder.dragAndDrop(getDraggable(), getDroppable())
                .perform();
    }

}
