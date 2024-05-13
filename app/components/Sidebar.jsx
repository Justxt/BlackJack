"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { GiHamburgerMenu } from "react-icons/gi";
import { Disclosure } from "@headlessui/react";
import {
  MdOutlineSpaceDashboard,
  MdOutlineAnalytics,
  MdOutlineIntegrationInstructions,
  MdOutlineMoreHoriz,
  MdOutlineSettings,
  MdOutlineLogout,
} from "react-icons/md";
import { CgProfile } from "react-icons/cg";
import { GiCreditsCurrency } from "react-icons/gi";
import { CiMap } from "react-icons/ci";
import { MdOutlineSecurity } from "react-icons/md";

export default function Sidebar() {
  const router = useRouter();

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (!token) {
      router.push("/login");
    }
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    router.push("/login");
  };

  const sideItems = [
    {
      name: "Cuenta",
      icon: (
        <CgProfile className="text-2xl text-gray-600 group-hover:text-white" />
      ),
      link: "/account",
    },
    {
      name: "Seguridad",
      icon: (
        <MdOutlineSecurity className="text-2xl text-gray-600 group-hover:text-white" />
      ),
      link: "/security",
    },
    {
      name: "Agregar Creditos",
      icon: (
        <GiCreditsCurrency className="text-2xl text-gray-600 group-hover:text-white" />
      ),
      link: "/add",
    },
    {
      name: "Retirar Ganancias",
      icon: (
        <MdOutlineAnalytics className="text-2xl text-gray-600 group-hover:text-white" />
      ),
      link: "/withdraw",
    },
    {
      name: "Ubicacion",
      icon: <CiMap className="text-2xl text-gray-600 group-hover:text-white" />,
      link: "/location",
    },
    {
      name: "Soporte",
      icon: (
        <MdOutlineIntegrationInstructions className="text-2xl text-gray-600 group-hover:text-white" />
      ),
      link: "/support",
    },
  ];

  return (
    <div>
      <Disclosure as="nav">
        <Disclosure.Button className="absolute top-4 right-4 inline-flex items-center peer justify-center rounded-md p-2 text-gray-800 hover:bg-gray-900 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white group">
          <GiHamburgerMenu
            className="block md:hidden h-6 w-6"
            aria-hidden="true"
          />
        </Disclosure.Button>
        <div className="p-6 w-1/2 h-screen bg-white z-20 fixed top-0 -left-96 lg:left-0 lg:w-60  peer-focus:left-0 peer:transition ease-out delay-150 duration-200">
          <div className="flex flex-col justify-start item-center">
            <h1 className="text-base text-center cursor-pointer font-bold text-black border-b border-gray-100 pb-4 w-full mb-4">
              BLACKJACK <span className="text-red-500">DASHBOARD</span>
            </h1>

            <div>
              {sideItems.map((item, index) => (
                <div
                  key={index}
                  className="flex mb-2 justify-start items-center gap-4 pl-5 hover:bg-red-500 p-2 rounded-md group cursor-pointer hover:shadow-lg m-auto"
                  onClick={() => router.push(item.link)}
                >
                  {item.icon}
                  <h3 className="text-base text-gray-800 group-hover:text-white font-semibold ">
                    {item.name}
                  </h3>
                </div>
              ))}
            </div>

            {/* logout */}
            <div className=" my-2 mt-20">
              <div className="flex mb-2 justify-start items-center pl-3">
                <button
                  className="border-2 text-red-500 border-red-500 rounded-full px-12 py-2 inline-block font-semibold hover:bg-white hover:text-black"
                  onClick={logout}
                >
                  Salir
                </button>
              </div>
            </div>
          </div>
        </div>
      </Disclosure>
    </div>
  );
}
