
package integracionpatrones.mediator;

public abstract class ComponenteEditor {

    protected DocumentEditorMediator mediator;

    public ComponenteEditor(
            DocumentEditorMediator mediator) {

        this.mediator = mediator;
    }

    public void setMediator(
            DocumentEditorMediator mediator) {

        this.mediator = mediator;
    }
}