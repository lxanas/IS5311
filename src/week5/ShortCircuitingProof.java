package week5;

public class ShortCircuitingProof
{
    public static void main(String[] args)
    {

        //---------Start of your code-------------
        // Add your code below for verifying the early circuiting
        // You should verify early circuiting for both && and || operators.
        Boolean a = false, b = false, c = false, d = false;
        if (a && (b = true))
        {
            System.out.println(a.toString() + b.toString());
        }
        System.out.println(a.toString() + b.toString());
        if ((c = true) || (d = true))
        {
            System.out.println(c.toString() + d.toString());
        }
        //---------End of your code-------------


		/*
			Explain inside this comment block about why 
			your code above can verify the Early circuiting.

			the output is "falsefalse truefalse".

			All the variables ofBoolean type var are initialized to false.
			In the first paragraph, the expressions before "&&" is false,so the expression after "&&" is not executed.

			In the second paragraph, only the first expression is executed, and the d variable does not change.

		*/
    }
}
