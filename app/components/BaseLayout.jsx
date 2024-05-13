import React from "react";
import Sidebar from "./Sidebar";

export default function BaseLayout({ children }) {
  return (
    <div className="flex justify-between h-screen">
      <div className="flex w-full justify-center">
        <Sidebar />
        <main className="flex justify-center items-center p-4 w-full">{children}</main>
      </div>
    </div>
  );
}