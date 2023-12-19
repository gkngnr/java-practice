package strings;

public class BlockIndent {

    public static void main(String[] args) {
        var block = """
                    a 
                     b 
                    c """;

        var b2 = """
                   a
                     b
                   c """;

        System.out.println(b2);

        var blockIndent = block.indent(1);

        System.out.println(block.length()); //9
        System.out.println(block);
        System.out.println(blockIndent.length());
        System.out.println(blockIndent);



    }
}
