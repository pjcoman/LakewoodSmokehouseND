package comapps.com.lakewoodsmokehousend.drinks;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

import comapps.com.lakewoodsmokehousend.Future;

public class Drinks
{
  private String group;
  private Double abv;
  private String item;
  private String objectId;
  private String price;
  private Integer groupsort;
  private Integer IBU;
  private java.util.Date created;
  private String ownerId;
  private java.util.Date updated;
  private String info;
  public String getGroup()
  {
    return group;
  }

  public void setGroup( String group )
  {
    this.group = group;
  }

  public Double getAbv()
  {
    return abv;
  }

  public void setAbv( Double abv )
  {
    this.abv = abv;
  }

  public String getItem()
  {
    return item;
  }

  public void setItem( String item )
  {
    this.item = item;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getPrice()
  {
    return price;
  }

  public void setPrice( String price )
  {
    this.price = price;
  }

  public Integer getGroupsort()
  {
    return groupsort;
  }

  public void setGroupsort( Integer groupsort )
  {
    this.groupsort = groupsort;
  }

  public Integer getIBU()
  {
    return IBU;
  }

  public void setIBU( Integer IBU )
  {
    this.IBU = IBU;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getInfo()
  {
    return info;
  }

  public void setInfo( String info )
  {
    this.info = info;
  }

                                                    
  public Drinks save()
  {
    return Backendless.Data.of( Drinks.class ).save( this );
  }

  public Future<Drinks> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Drinks> future = new Future<Drinks>();
      Backendless.Data.of( Drinks.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Drinks> callback )
  {
    Backendless.Data.of( Drinks.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Drinks.class ).remove( this );
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
      Backendless.Data.of( Drinks.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Drinks.class ).remove( this, callback );
  }

  public static Drinks findById( String id )
  {
    return Backendless.Data.of( Drinks.class ).findById( id );
  }

  public static Future<Drinks> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Drinks> future = new Future<Drinks>();
      Backendless.Data.of( Drinks.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Drinks> callback )
  {
    Backendless.Data.of( Drinks.class ).findById( id, callback );
  }

  public static Drinks findFirst()
  {
    return Backendless.Data.of( Drinks.class ).findFirst();
  }

  public static Future<Drinks> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Drinks> future = new Future<Drinks>();
      Backendless.Data.of( Drinks.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Drinks> callback )
  {
    Backendless.Data.of( Drinks.class ).findFirst( callback );
  }

  public static Drinks findLast()
  {
    return Backendless.Data.of( Drinks.class ).findLast();
  }

  public static Future<Drinks> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Drinks> future = new Future<Drinks>();
      Backendless.Data.of( Drinks.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Drinks> callback )
  {
    Backendless.Data.of( Drinks.class ).findLast( callback );
  }

  public static BackendlessCollection<Drinks> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Drinks.class ).find( query );
  }

  public static Future<BackendlessCollection<Drinks>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Drinks>> future = new Future<BackendlessCollection<Drinks>>();
      Backendless.Data.of( Drinks.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Drinks>> callback )
  {
    Backendless.Data.of( Drinks.class ).find( query, callback );
  }
}