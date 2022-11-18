/* eslint-disable indent */
/* eslint-disable object-curly-spacing */
/* eslint-disable max-len */
import * as admin from "firebase-admin";
import * as functions from "firebase-functions";
import { doCreateUser, User, validateUsers } from "./util";

interface CreateUserBody {
  admin: boolean;
  user?: User;
  users?: User[];
}

export const createUser = functions.https.onCall(async (data: CreateUserBody, context) => {
  if (!context.auth || !context.auth.token.admin) {
    return { error: "Forbidden" };
  }

  if (data.user && data.users) {
    return { error: "exactly ONE of the user properties must be provided" };
  }

  if (!data.admin) {
    data.admin = false;
  }

  if (data.user) {
    try {
      const [u] = validateUsers([data.user], data.admin, context.auth.uid);
      await doCreateUser(u);
      return { "status": "ok" };
    } catch (e) {
      return { "error": "could not create user", "message": e };
    }
  }

  try {
    const tasks = validateUsers(data.users!, data.admin, context.auth.uid)
      .map((u) => doCreateUser(u));
    await Promise.all(tasks);
  } catch (e) {
    return { "error": "could not create users", "message": e };
  }

  return { "status": "ok" };
});
