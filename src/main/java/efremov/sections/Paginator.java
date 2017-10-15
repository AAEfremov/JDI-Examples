package efremov.sections;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.openqa.selenium.support.FindBy;

public class Paginator extends Pagination {

    @FindBy(css =  ".prev a")
    public IButton prev;

    @FindBy(css =  ".first a")
    public IButton first;

    @FindBy(css =  ".last a")
    public IButton last;

    @FindBy(css =  ".next a")
    public IButton next;

}
