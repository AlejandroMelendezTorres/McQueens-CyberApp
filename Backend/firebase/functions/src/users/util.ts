/* eslint-disable object-curly-spacing */
/* eslint-disable indent */
/* eslint-disable max-len */
import * as admin from "firebase-admin";
import { firestore } from "firebase-admin";

export interface User {
  id: string;
  username: string;
  email: string;
  password?: string;
  createdBy: string;
  createdAt: admin.firestore.Timestamp | admin.firestore.FieldValue;
  lastActive: firestore.Timestamp | admin.firestore.FieldValue;
  isAdmin: boolean;
}

export const validateUsers = (users: User[], isadmin: boolean, createdBy: string) => {
  for (const u of users) {
    if (!u.email || !u.username || !u.password) {
      throw new Error("invalid user, users must have email, username and password");
    }
    u.createdBy = createdBy;
    u.isAdmin = isadmin;
    u.createdAt = admin.firestore.FieldValue.serverTimestamp();
    u.lastActive = admin.firestore.FieldValue.serverTimestamp();
  }
  return users;
};

export const doCreateUser = async (user: User) => {
  const record = await admin.auth().createUser({
    email: user.email,
    password: user.password,
    displayName: user.username,
  });

  await admin.auth().setCustomUserClaims(record.uid, {
    admin: user.isAdmin,
    user: true,
  });

  user.id = record.uid;
  delete user.password;
  await admin.firestore().collection("users")
    .doc(record.uid)
    .set(user);
};
