package comapps.com.lakewoodsmokehousend.menu;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class MenuGroups
{
  private Integer sort;
  private String type;
  private String ownerId;
  private String objectId;
  private String group;
  private java.util.Date updated;
  private java.util.Date created;
  public Integer getSort()
  {
    return sort;
  }

  public void setSort( Integer sort )
  {
    this.sort = sort;
  }

  public String getType()
  {
    return type;
  }

  public void setType( String type )
  {
    this.type = type;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getGroup()
  {
    return group;
  }

  public void setGroup( String group )
  {
    this.group = group;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public MenuGroups save()
  {
    return Backendless.Data.of( MenuGroups.class ).save( this );
  }

 /* public Future<MenuGroups> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<MenuGroups> future = new Future<MenuGroups>();
      Backendless.Data.of( MenuGroups.class ).save( this, future );

      return future;
    }
  }*/

  public void saveAsync( AsyncCallback<MenuGroups> callback )
  {
    Backendless.Data.of( MenuGroups.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( MenuGroups.class ).remove( this );
  }

  /*public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( MenuGroups.class ).remove( this, future );

      return future;
    }
  }*/

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( MenuGroups.class ).remove( this, callback );
  }

  public static MenuGroups findById( String id )
  {
    return Backendless.Data.of( MenuGroups.class ).findById( id );
  }

 /* public static Future<MenuGroups> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<MenuGroups> future = new Future<MenuGroups>();
      Backendless.Data.of( MenuGroups.class ).findById( id, future );

      return future;
    }
  }*/

  public static void findByIdAsync( String id, AsyncCallback<MenuGroups> callback )
  {
    Backendless.Data.of( MenuGroups.class ).findById( id, callback );
  }

  public static MenuGroups findFirst()
  {
    return Backendless.Data.of( MenuGroups.class ).findFirst();
  }

 /* public static Future<MenuGroups> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<MenuGroups> future = new Future<MenuGroups>();
      Backendless.Data.of( MenuGroups.class ).findFirst( future );

      return future;
    }
  }*/

  public static void findFirstAsync( AsyncCallback<MenuGroups> callback )
  {
    Backendless.Data.of( MenuGroups.class ).findFirst( callback );
  }

  public static MenuGroups findLast()
  {
    return Backendless.Data.of( MenuGroups.class ).findLast();
  }

  /*public static Future<MenuGroups> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<MenuGroups> future = new Future<MenuGroups>();
      Backendless.Data.of( MenuGroups.class ).findLast( future );

      return future;
    }
  }*/

  public static void findLastAsync( AsyncCallback<MenuGroups> callback )
  {
    Backendless.Data.of( MenuGroups.class ).findLast( callback );
  }

  public static BackendlessCollection<MenuGroups> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( MenuGroups.class ).find( query );
  }

 /* public static Future<BackendlessCollection<MenuGroups>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<MenuGroups>> future = new Future<BackendlessCollection<MenuGroups>>();
      Backendless.Data.of( MenuGroups.class ).find( query, future );

      return future;
    }
  }*/

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<MenuGroups>> callback )
  {
    Backendless.Data.of( MenuGroups.class ).find( query, callback );
  }
}