/*
 * Chernov Dmitriy
 * 271 group
 */

package interpreter.TreeNodes;

public class Op extends Expression  
{
    private Expression left;
    private Expression right;
    private OpType op;
    
    public Op(OpType op, Expression left, Expression right) 
    {
        this.left = left;
        this.right = right;
        this.op = op;
        type = ExprType.BINOP; 
    }
    
    public OpType getOp() {
        return op;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }
    
    public void setRight(Expression r) {
        right = r;
    }
    
    public void setLeft(Expression l) {
        left = l;
    }

    @Override
    public Object deepcopy() {
        return new Op(op,(Expression)left.deepcopy(),(Expression)right.deepcopy());
    }
}
