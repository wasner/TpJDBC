/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;


public class Notation {
    private float moyCC;
    private float moyTest;

    public Notation() {
    }

    public Notation(float moyCC, float moyTest) {
        this.moyCC = moyCC;

        this.moyTest = moyTest;
    }

    public void setMoyCC(float moyCC) { this.moyCC = moyCC; }

    public void setMoyTest(float moyTest) { this.moyTest = moyTest; }

    public float getMoyCC() { return moyCC; }

    public float getMoyTest() { return moyTest; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notation notation = (Notation) o;

        if (Float.compare(notation.moyCC, moyCC) != 0) return false;
        return Float.compare(notation.moyTest, moyTest) == 0;

    }

    @Override
    public int hashCode() {
        int result = (moyCC != +0.0f ? Float.floatToIntBits(moyCC) : 0);
        result = 31 * result + (moyTest != +0.0f ? Float.floatToIntBits(moyTest) : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Notation{");
        sb.append("moyCC=").append(moyCC);
        sb.append(", moyTest=").append(moyTest);
        sb.append('}');
        return sb.toString();
    }
}
