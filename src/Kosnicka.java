import java.util.*;

public class Kosnicka {
    public static class Product {
        String name;
        String category;
        float price;
        Product(){}
        Product(String name, String category, float price)
        {
            this.name=name;
            this.category=category;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
    public static class Cart{
        private List<Product> products = new ArrayList<Product>();

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void addProduct(Product product) {
            products.add(product);
        }
        public void printByCategory(String category){
            System.out.println("Припаѓаат во категорија " + category +": ");
            for(Product product : products) {
                if((product.getCategory()).equals(category))
                {
                    System.out.println(product.getName() + " " + product.getCategory() + " " + product.getPrice() + " ");
                }

            }
        }
        public List<Product> getCheapestN(int n){
            Product temp;
            for ( int i = 0; i < products.size() ; i++ ) {
                for ( int j = i+1; j < products.size(); j++ ) {
                    if(products.get(i).getPrice() > products.get(j).getPrice()){
                        temp=products.get(i);
                        products.set(i,products.get(j));
                        products.set(j,temp);
                    }
                }
            }
            List<Product> cheapest = new ArrayList<Product>();
            for ( int i = 0; i < n; i++ ) {
                cheapest.add(products.get(i));
            }
            return cheapest;
        }

        public float getTotalPrice(){
            float total=0f;
            for ( int i = 0; i < products.size() ; i++ ) {
                total+=products.get(i).getPrice();
            }
            return total;
        }
        public void printPaymentReceipt(){

            System.out.println("Име на продукт   Количина    Единечна цена   Цена");
            for ( int i = 0; i < products.size(); i++ ) {
                int counter=1;
                if(products.get(i).getName()!=null)
                {
                    for ( int j = i+1; j < products.size(); j++ ) {
                        if(products.get(i).getName() == products.get(j).getName())
                        {
                            counter++;
                            products.get(j).setName(null);
                        }
                    }
                    System.out.println(products.get(i).getName()+ "          " + counter + "          " + products.get(i).getPrice() + "          " + counter*products.get(i).getPrice() + " ");

                }
            }
        }
    }
    public static void main(String[] args) {
        Product pr1 = new Product();
        Product pr2 = new Product();
        Product pr3 = new Product();

        pr1.setName("product1");
        pr1.setCategory("categoryA");
        pr1.setPrice(100);
        //Za proverka dokolku se povtoruvaat produktite dali e tocna printPaymentReceipt() funkcijata
//        pr2.setName("product1");
//        pr2.setCategory("categoryA");
//        pr2.setPrice(100);
//        pr3.setName("product1");
//        pr3.setCategory("categoryA");
//        pr3.setPrice(100);

        pr2.setName("product2");
        pr2.setCategory("categoryA");
        pr2.setPrice(200);

        pr3.setName("product3");
        pr3.setCategory("categoryB");
        pr3.setPrice(300);

        Cart cart = new Cart();
        cart.addProduct(pr1);
        cart.addProduct(pr2);
        cart.addProduct(pr3);



        cart.printByCategory("categoryA");
        List<Product> cheapest = new ArrayList<Product>();
        cheapest=cart.getCheapestN(2);
//        System.out.println("Листа од најевтините N продукти: ");
//        for ( int i = 0; i < cheapest.size(); i++ ) {
//            System.out.println(cheapest.get(i).getName() + " " + cheapest.get(i).getCategory() + " " + cheapest.get(i).getPrice());
//        }
        float price=cart.getTotalPrice();
        cart.printPaymentReceipt();
        float ddv;
        ddv= (float) (0.18*price);
        float totalPrice=price+ddv;
        System.out.println("Вкупна цена со пресметан ДДВ: " + totalPrice );


    }
}
