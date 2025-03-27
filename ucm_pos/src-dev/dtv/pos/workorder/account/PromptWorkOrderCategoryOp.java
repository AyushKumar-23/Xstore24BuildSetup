
// Warning: No line numbers available in class file
package dtv.pos.workorder.account;

import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.cwo.IWorkOrderCategory;
import javax.inject.Inject;

public class PromptWorkOrderCategoryOp extends AbstractListPromptOp {
   @Inject
   private WorkOrderHelper _workOrderHelper;

   public String getDefaultPromptKey() {
      return "WORK_ORDER_CATEGORY";// 27
   }

   public IOpResponse handlePromptResponse(IXstEvent argEvent) {
      IWorkOrderAccount account = this._workOrderHelper.getCurrentWorkOrderAccount();// 38
      account.setWorkOrderAccountCategory((IWorkOrderCategory)argEvent.getData());// 39
      return this.HELPER.completeResponse();// 41
   }

   protected String getEmptyListPromptKey() {
      return null;// 48
   }

   protected Object[] getPromptList(IXstEvent argEvent) {
      return this._workOrderHelper.getWorkOrderCategories().toArray();// 54
   }

   protected boolean showListIfOne() {
      return false;// 64
   }
}
