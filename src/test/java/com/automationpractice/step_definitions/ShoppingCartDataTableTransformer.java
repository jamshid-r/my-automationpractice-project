package com.automationpractice.step_definitions;


	import java.util.Locale;
	import java.util.Map;
	import io.cucumber.core.api.TypeRegistry;
	import io.cucumber.core.api.TypeRegistryConfigurer;
	import io.cucumber.datatable.DataTableType;
	import io.cucumber.datatable.TableEntryTransformer;
	import com.automationpractice.beans.ShoppingCart;

	public class ShoppingCartDataTableTransformer  implements TypeRegistryConfigurer {
	    
	    public Locale locale() {
	        return Locale.ENGLISH;
	    }
	    public void configureTypeRegistry(TypeRegistry typeRegistry) {
	        typeRegistry.defineDataTableType(new DataTableType(ShoppingCart.class,
	                       new TableEntryTransformer<ShoppingCart>() {
	                    
	            @Override
	            
	            public ShoppingCart transform(Map<String, String> row) throws Throwable{
	                          
	                            String description = row.get("Description");
	                            String unitPrice = row.get("Unit price");
	                            String quantity = row.get("Quantity");
	                            String totalBefore = row.get("Product Total");
	                            String totalAfter = row.get("Total After Fees");
	                           
	                            return new ShoppingCart(description, unitPrice, quantity, totalBefore, totalAfter);       
	                            		
	                            			                        }
	                    }));
	    }
	}


