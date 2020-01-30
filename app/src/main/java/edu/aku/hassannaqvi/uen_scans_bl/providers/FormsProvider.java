 /*
  * Copyright (C) 2014 The Android Open Source Project
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
 package edu.aku.hassannaqvi.uen_scans_bl.providers;

 import android.content.ContentProvider;
 import android.content.ContentValues;
 import android.content.UriMatcher;
 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.net.Uri;

 import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
 import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;

 public class FormsProvider extends ContentProvider {


     private static final int FORMS = 100;
     private static final int FORMS_WITH_CHILDREN = 101;
     private static final int FORMS_WITH_CHILDREN_AND_DATE = 102;
     // The URI Matcher used by this content provider.
     private static final UriMatcher sUriMatcher = buildUriMatcher();
     private static final int CHILDREN = 300;
     private static final int CHILDREN_ID = 301;
     private DatabaseHelper mOpenHelper;

     private static UriMatcher buildUriMatcher() {
         // I know what you're thinking.  Why create a UriMatcher when you can use regular
         // expressions instead?  Because you're not crazy, that's why.

         // All paths added to the UriMatcher have a corresponding code to return when a match is
         // found.  The code passed into the constructor represents the code to return for the root
         // URI.  It's common to use NO_MATCH as the code for this case.
         final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
         final String authority = FormsContract.CONTENT_AUTHORITY;

         // For each type of URI you want to add, create a corresponding code.
         matcher.addURI(authority, FormsContract.PATH_FORMS, FORMS);
         matcher.addURI(authority, FormsContract.PATH_FORMS + "/*", FORMS_WITH_CHILDREN);
         matcher.addURI(authority, FormsContract.PATH_FORMS + "/*/*", FORMS_WITH_CHILDREN_AND_DATE);

         //matcher.addURI(authority, FormsContract.PATH_CHILD, CHILDNAME);
         //matcher.addURI(authority, FormsContract.PATH_CHILD + "/#", STUDY_ID);

         return matcher;
     }

     /*
          private static final SQLiteQueryBuilder sFormsByDSSIDQueryBuilder;

          static {
              sFormsByDSSIDQueryBuilder = new SQLiteQueryBuilder();
              sFormsByDSSIDQueryBuilder.setTables(
                      FormsContract.FormsTable.TABLE_NAME + " INNER JOIN " +
                              FormsContract.ChildrenTable.TABLE_NAME +
                              " ON " + FormsContract.FormsTable.TABLE_NAME +
                              "." + FormsContract.FormsTable.COLUMN_LOC_KEY +
                              " = " + FormsContract.ChildrenTable.TABLE_NAME +
                              "." + FormsContract.ChildrenTable._ID);
          }

          private static final String sStudyIDSelection =
                  FormsContract.ChildrenTable.TABLE_NAME +
                          "." + FormsContract.ChildrenTable.COLUMN_CHILDREN_SETTING + " = ? ";
          private static final String sStudyIDWithStartDateSelection =
                  FormsContract.ChildrenTable.TABLE_NAME +
                          "." + FormsContract.ChildrenTable.COLUMN_CHILDREN_SETTING + " = ? AND " +
                          FormsContract.FormsTable.COLUMN_DATETEXT + " >= ? ";

          private static final String sStudyIDAndDaySelection =
                  FormsContract.ChildrenTable.TABLE_NAME +
                          "." + FormsContract.ChildrenTable.COLUMN_CHILDREN_SETTING + " = ? AND " +
                          FormsContract.FormsTable.COLUMN_DATETEXT + " = ? ";

          private Cursor getFormsByStudyID(Uri uri, String[] projection, String sortOrder) {
              String StudyID = FormsContract.FormsTable.getStudyIDFromUri(uri);
              String startDate = FormsContract.FormsTable.getStartDateFromUri(uri);

              String[] selectionArgs;
              String selection;

              if (startDate == null) {
                  selection = sStudyIDSelection;
                  selectionArgs = new String[]{StudyID};
              } else {
                  selectionArgs = new String[]{StudyID, startDate};
                  selection = sStudyIDWithStartDateSelection;
              }

              return sFormsByDSSIDQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                      projection,
                      selection,
                      selectionArgs,
                      null,
                      null,
                      sortOrder
              );
          }


          private Cursor getFormsByStudyIDAndDate(
                  Uri uri, String[] projection, String sortOrder) {
              String StudyID = FormsContract.FormsTable.getStudyIDFromUri(uri);
              String date = FormsContract.FormsTable.getDateFromUri(uri);

              return sFormsByDSSIDQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                      projection,
                      sStudyIDAndDaySelection,
                      new String[]{StudyID, date},
                      null,
                      null,
                      sortOrder
              );
          }
     */
     @Override
     public boolean onCreate() {
         mOpenHelper = new DatabaseHelper(getContext());
         return true;
     }

     @Override
     public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                         String sortOrder) {
         // Here's the switch statement that, given a URI, will determine what kind of request it is,
         // and query the database accordingly.
         Cursor retCursor;


         switch (sUriMatcher.match(uri)) {
             // "FORMS/*/*"
             case FORMS_WITH_CHILDREN_AND_DATE: {
                 //                retCursor = getFormsByStudyIDAndDate(uri, projection, sortOrder);
                 break;
             }
             // "FORMS/*"
             case FORMS_WITH_CHILDREN: {
                 //                retCursor = getFormsByStudyID(uri, projection, sortOrder);
                 break;
             }
             // "FORMS"
             case FORMS: {
                 retCursor = mOpenHelper.getReadableDatabase().query(
                         FormsContract.FormsTable.TABLE_NAME,
                         projection,
                         selection,
                         selectionArgs,
                         null,
                         null,
                         sortOrder
                 );
                 break;
             }

             /**
              * TODO
              **/

             default:
                 throw new UnsupportedOperationException("Unknown uri: " + uri);
         }
//        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
//         return retCursor;
         return null;
     }

     @Override
     public String getType(Uri uri) {

         // Use the Uri Matcher to determine what kind of URI this is.
         final int match = sUriMatcher.match(uri);

         switch (match) {
             case FORMS_WITH_CHILDREN_AND_DATE:
//                 return FormsContract.FormsTable.CONTENT_ITEM_TYPE;
             case FORMS_WITH_CHILDREN:
//                 return FormsContract.FormsTable.CONTENT_TYPE;
             case FORMS:
//                 return FormsContract.FormsTable.CONTENT_TYPE;

                 /**
                  * TODO
                  **/

             default:
                 throw new UnsupportedOperationException("Unknown uri: " + uri);
         }
     }

     @Override
     public Uri insert(Uri uri, ContentValues values) {
         final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
         final int match = sUriMatcher.match(uri);
         Uri returnUri;

         returnUri = Uri.parse("http://google.com");  // TEMPORTRARY FIX

/*
         switch (match) {
             case FORMS: {
                 long _id = db.insert(FormsContract.FormsTable.TABLE_NAME, null, values);
                 if (_id > 0)
                     returnUri = FormsContract.FormsTable.buildFormsUri(_id);
                 else
                     throw new android.database.SQLException("Failed to insert row into " + uri);
                 break;
             }
             case CHILDREN: {
                 long _id = db.insert(FormsContract.ChildrenTable.TABLE_NAME, null, values);
                 if (_id > 0)
                     returnUri = FormsContract.ChildrenTable.buildChildrenUri(_id);
                 else
                     throw new android.database.SQLException("Failed to insert row into " + uri);
                 break;
             }
             default:
                 throw new UnsupportedOperationException("Unknown uri: " + uri);
         }
*/
         getContext().getContentResolver().notifyChange(uri, null);
         return returnUri;

     }

     @Override
     public int delete(Uri uri, String selection, String[] selectionArgs) {
         final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
         final int match = sUriMatcher.match(uri);
         int rowsDeleted;
         switch (match) {
             case FORMS:
                 rowsDeleted = db.delete(
                         FormsContract.FormsTable.TABLE_NAME, selection, selectionArgs);
                 break;
/*
             case CHILDREN:
                 rowsDeleted = db.delete(
                         FormsContract.ChildrenTable.TABLE_NAME, selection, selectionArgs);
                 break;
*/
             default:
                 throw new UnsupportedOperationException("Unknown uri: " + uri);
         }
         // Because a null deletes all rows
         if (selection == null || rowsDeleted != 0) {
             getContext().getContentResolver().notifyChange(uri, null);
         }
         return rowsDeleted;
     }

     @Override
     public int update(
             Uri uri, ContentValues values, String selection, String[] selectionArgs) {
         /**
          * TODO 
          *
          **/
         return 0;
     }

     @Override
     public int bulkInsert(Uri uri, ContentValues[] values) {
         final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
         final int match = sUriMatcher.match(uri);
         switch (match) {
             case FORMS:
                 db.beginTransaction();
                 int returnCount = 0;
                 try {
                     for (ContentValues value : values) {
                         long _id = db.insert(FormsContract.FormsTable.TABLE_NAME, null, value);
                         if (_id != -1) {
                             returnCount++;
                         }
                     }
                     db.setTransactionSuccessful();
                 } finally {
                     db.endTransaction();
                 }
                 getContext().getContentResolver().notifyChange(uri, null);
                 return returnCount;
             default:
                 return super.bulkInsert(uri, values);
         }
     }
 }
