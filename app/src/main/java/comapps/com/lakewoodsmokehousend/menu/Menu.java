package comapps.com.lakewoodsmokehousend.menu;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

import comapps.com.lakewoodsmokehousend.Future;

public class Menu
{
  private Integer sort;
  private String description;
  private String group;
  private String price;
  private String item;
  private String quantitylabel;
  private Integer quantity = 0;
  private Integer selection = 0;
  private Integer selection2 = 0;
  private Integer selection3 = 0;
  private Integer selection4 = 0;
  private Integer selection5 = 0;
  private Integer selection6 = 0;
  private Integer groupsort;
  private String order;
  private java.util.Date updated;
  private java.util.Date created;
  private String ownerId;
  private String objectId;
  public Integer getSort()
  {
    return sort;
  }

  public void setSort( Integer sort )
  {
    this.sort = sort;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( String description )
  {
    this.description = description;
  }

  public String getGroup()
  {
    return group;
  }

  public void setGroup( String group )
  {
    this.group = group;
  }

  public String getPrice()
  {
    return price;
  }

  public void setPrice( String price )
  {
    this.price = price;
  }

  public String getItem()
  {
    return item;
  }

  public void setItem( String item )
  {
    this.item = item;
  }

  public Integer getGroupsort()
  {
    return groupsort;
  }

  public void setGroupsort( Integer groupsort )
  {
    this.groupsort = groupsort;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getQuantityLabel() {
    return quantitylabel;
  }

  public void setQuantityLabel(String quantitylabel) {
    this.quantitylabel = quantitylabel;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getSelection() {
    return selection;
  }

  public void setSelection(Integer selection) {
    this.selection = selection;
  }

  public Integer getSelection2() {
    return selection2;
  }

  public void setSelection2(Integer selection2) {
    this.selection2 = selection2;
  }

  public Integer getSelection3() {
    return selection3;
  }

  public void setSelection3(Integer selection3) {
    this.selection3 = selection3;
  }

  public Integer getSelection4() {
    return selection4;
  }

  public void setSelection4(Integer selection4) {
    this.selection4 = selection4;
  }

  public Integer getSelection5() {
    return selection5;
  }

  public void setSelection5(Integer selection5) {
    this.selection5 = selection5;
  }

  public Integer getSelection6() {
    return selection6;
  }

  public void setSelection6(Integer selection6) {
    this.selection6 = selection6; }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

                                                    
  public Menu save()
  {
    return Backendless.Data.of( Menu.class ).save( this );
  }

  public Future<Menu> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Menu> future = new Future<Menu>();
      Backendless.Data.of( Menu.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Menu.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Menu.class ).remove( this, future );

      return future;
    }
  }
  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Menu.class ).remove( this, callback );
  }

  public static Menu findById( String id )
  {
    return Backendless.Data.of( Menu.class ).findById( id );
  }

  public static Future<Menu> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Menu> future = new Future<Menu>();
      Backendless.Data.of( Menu.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findById( id, callback );
  }

  public static Menu findFirst()
  {
    return Backendless.Data.of( Menu.class ).findFirst();
  }

  public static Future<Menu> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Menu> future = new Future<Menu>();
      Backendless.Data.of( Menu.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findFirst( callback );
  }

  public static Menu findLast()
  {
    return Backendless.Data.of( Menu.class ).findLast();
  }

  public static Future<Menu> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Menu> future = new Future<Menu>();
      Backendless.Data.of( Menu.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findLast( callback );
  }

  public static BackendlessCollection<Menu> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Menu.class ).find( query );
  }

  public static Future<BackendlessCollection<Menu>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Menu>> future = new Future<BackendlessCollection<Menu>>();
      Backendless.Data.of( Menu.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Menu>> callback )
  {
    Backendless.Data.of( Menu.class ).find( query, callback );
  }
}