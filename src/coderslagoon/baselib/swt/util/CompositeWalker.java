package coderslagoon.baselib.swt.util;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class CompositeWalker {
    public boolean walk(Composite cmp) {
        for (Control ctl : cmp.getChildren()) {
            if (!onControl(ctl)) {
                return false;
            }
            if (ctl instanceof Composite) {
                if(!walk((Composite)ctl)) {
                    return false;
                }
            }
        }
        return true;
    }
    protected abstract boolean onControl(Control ctl);
}
