package comapps.com.lakewoodsmokehousend.reviews;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Review
{
  private String objectId;
  private String ACL;
  private String review;
  private String reviewname;
  private String ownerId;
  private java.util.Date updated;
  private java.util.Date created;
  private String rating;
  public String getObjectId()
  {
    return objectId;
  }

  public String getACL()
  {
    return ACL;
  }

  public void setACL( String ACL )
  {
    this.ACL = ACL;
  }

  String getReview()
  {
    return review;
  }

  public void setReview( String review )
  {
    this.review = review;
  }

  public String getReviewname()
  {
    return reviewname;
  }

  public void setReviewname( String reviewname )
  {
    this.reviewname = reviewname;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getRating()
  {
    return rating;
  }

  public void setRating( String rating )
  {
    this.rating = rating;
  }

                                                    
  public Review save()
  {
    return Backendless.Data.of( Review.class ).save( this );
  }

 /* public Future<Review> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Review> future = new Future<Review>();
      Backendless.Data.of( Review.class ).save( this, future );

      return future;
    }
  }*/

  public void saveAsync( AsyncCallback<Review> callback )
  {
    Backendless.Data.of( Review.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Review.class ).remove( this );
  }

/*  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Review.class ).remove( this, future );

      return future;
    }
  }*/

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Review.class ).remove( this, callback );
  }

  public static Review findById( String id )
  {
    return Backendless.Data.of( Review.class ).findById( id );
  }

 /* public static Future<Review> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Review> future = new Future<Review>();
      Backendless.Data.of( Review.class ).findById( id, future );

      return future;
    }
  }*/

  public static void findByIdAsync( String id, AsyncCallback<Review> callback )
  {
    Backendless.Data.of( Review.class ).findById( id, callback );
  }

  public static Review findFirst()
  {
    return Backendless.Data.of( Review.class ).findFirst();
  }

  /*public static Future<Review> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Review> future = new Future<Review>();
      Backendless.Data.of( Review.class ).findFirst( future );

      return future;
    }
  }*/

  public static void findFirstAsync( AsyncCallback<Review> callback )
  {
    Backendless.Data.of( Review.class ).findFirst( callback );
  }

  public static Review findLast()
  {
    return Backendless.Data.of( Review.class ).findLast();
  }

  /*public static Future<Review> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Review> future = new Future<Review>();
      Backendless.Data.of( Review.class ).findLast( future );

      return future;
    }
  }*/

  public static void findLastAsync( AsyncCallback<Review> callback )
  {
    Backendless.Data.of( Review.class ).findLast( callback );
  }

  public static BackendlessCollection<Review> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Review.class ).find( query );
  }

 /* public static Future<BackendlessCollection<Review>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Review>> future = new Future<BackendlessCollection<Review>>();
      Backendless.Data.of( Review.class ).find( query, future );

      return future;
    }
  }
*/
  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Review>> callback )
  {
    Backendless.Data.of( Review.class ).find( query, callback );
  }
}